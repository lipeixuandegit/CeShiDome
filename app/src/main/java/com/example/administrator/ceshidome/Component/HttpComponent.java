package com.example.administrator.ceshidome.Component;

import com.example.administrator.ceshidome.Module.HttpModule;
import com.example.administrator.ceshidome.ui.mobile.MobileFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/28.
 */
@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(MobileFragment mobileFragment);
}
