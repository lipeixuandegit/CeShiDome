package com.example.administrator.ceshidome.ui.mobile.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ceshidome.R;
import com.example.administrator.ceshidome.bean.MobileBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/28.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MobileBean.NewslistBean> list;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MobileBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        MobileViewHolder mobileViewHolder = new MobileViewHolder(view);
        return mobileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MobileViewHolder mobileViewHolder= (MobileViewHolder) holder;
        MobileBean.NewslistBean newslistBean = list.get(position);
        mobileViewHolder.img.setImageURI(newslistBean.getPicUrl());
        mobileViewHolder.tv1.setText(newslistBean.getTitle());
        mobileViewHolder.tv2.setText(newslistBean.getCtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MobileViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView tv1;
        private final TextView tv2;

        public MobileViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tv1 = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);


        }
    }
    //刷新
    public void refresh(List<MobileBean.NewslistBean> tlist){
        this.list.clear();
        this.list.addAll(tlist);
        notifyDataSetChanged();

    }
    //加载更多
    public void loadMore(List<MobileBean.NewslistBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();

    }
}
