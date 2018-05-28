package com.example.administrator.ceshidome.ui.mobile.Presenter;

import com.example.administrator.ceshidome.bean.MobileBean;
import com.example.administrator.ceshidome.net.MobileAPi;
import com.example.administrator.ceshidome.ui.base.Presenter.BasePresenter;
import com.example.administrator.ceshidome.ui.mobile.Contract.MobileContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/28.
 */

public class MobilePresenter extends BasePresenter<MobileContract.View> implements MobileContract.Presenter {
    private MobileAPi mobileAPi;
    @Inject
    public MobilePresenter(MobileAPi mobileAPi) {
        this.mobileAPi = mobileAPi;
    }
    @Override
    public void getMobile() {
        mobileAPi.getMobile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MobileBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MobileBean mobileBean) {
                        mView.onSuccess(mobileBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
