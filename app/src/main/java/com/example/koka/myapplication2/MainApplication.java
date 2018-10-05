package com.example.koka.myapplication2;

import android.app.Application;
import android.content.Context;

import com.example.koka.myapplication2.Helper.LocaleHelper;


public class MainApplication extends Application{

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
