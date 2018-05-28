package com.example.administrator.ceshidome.ui.base.Contract;

/**
 * Created by Administrator on 2018/5/28.
 */

public interface BaseContract {
    interface BasePresenter<T extends BaseView>{
        void attchView(T view);
        void detachView();

    }
    interface BaseView{
        void showLoading();

        void dismissLoading();
    }
}
