package com.example.administrator.ceshidome.ui.mobile.Contract;

import android.view.View;

import com.example.administrator.ceshidome.bean.MobileBean;
import com.example.administrator.ceshidome.ui.base.Contract.BaseContract;

/**
 * Created by Administrator on 2018/5/28.
 */

public interface MobileContract {

    interface View extends BaseContract.BaseView{
        void onSuccess(MobileBean mobileBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void getMobile();
    }
}
