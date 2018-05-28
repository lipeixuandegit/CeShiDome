package com.example.administrator.ceshidome.inter;

import android.view.View;

/**
 * Created by Administrator on 2018/5/28.
 */

public interface IBase {
    int getContentLayout();
    void inject();
    void initView(View view);
}
