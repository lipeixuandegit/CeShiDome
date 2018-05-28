package com.example.administrator.ceshidome.ui.base.Presenter;

import com.example.administrator.ceshidome.ui.base.Contract.BaseContract;

/**
 * Created by Administrator on 2018/5/28.
 */

public class BasePresenter <T extends BaseContract.BaseView> implements  BaseContract.BasePresenter<T> {
    protected T mView;
    @Override
    public void attchView(T view) {
        this.mView=view;

    }

    @Override
    public void detachView() {
        if (mView!=null){
            mView=null;
        }

    }
}
