package com.example.administrator.ceshidome.ui.mobile;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ceshidome.Component.DaggerHttpComponent;
import com.example.administrator.ceshidome.Module.HttpModule;
import com.example.administrator.ceshidome.R;
import com.example.administrator.ceshidome.bean.MobileBean;
import com.example.administrator.ceshidome.ui.base.BaseFragment;
import com.example.administrator.ceshidome.ui.mobile.Adapter.MyAdapter;
import com.example.administrator.ceshidome.ui.mobile.Contract.MobileContract;
import com.example.administrator.ceshidome.ui.mobile.Presenter.MobilePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/28.
 */

public class MobileFragment extends BaseFragment<MobilePresenter> implements MobileContract.View {
    private View view;
    private XRecyclerView mXrlv;
    private boolean isRefresh = true;
    private MyAdapter adapter;

    @Override
    public int getContentLayout() {
        return R.layout.mobile_item;
    }

    @Override
    public void inject() {
        DaggerHttpComponent
                .builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mXrlv = (XRecyclerView) view.findViewById(R.id.xrlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXrlv.setLayoutManager(linearLayoutManager);
        mPresenter.getMobile();
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                isRefresh=true;
                mPresenter.getMobile();
            }

            @Override
            public void onLoadMore() {
                isRefresh=false;
                mPresenter.getMobile();
            }
        });
    }

    @Override
        public void onSuccess(MobileBean mobileBean) {

        List<MobileBean.NewslistBean> tlist=new ArrayList<>();
        tlist.addAll(mobileBean.getNewslist());
        if (isRefresh){
            adapter = new MyAdapter(getContext(), mobileBean.getNewslist());
            mXrlv.setAdapter(adapter);
            adapter.refresh(tlist);
            mXrlv.refreshComplete();

        }else {
            if (adapter!=null){
                adapter.loadMore(tlist);
                mXrlv.loadMoreComplete();
            }
        }
        if (adapter==null){
            return;
        }

    }

}
