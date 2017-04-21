package com.ben.xplain.dagger.app;

import android.content.Context;

import com.ben.xplain.app.XApplication;
import com.ben.xplain.dagger.login.LoginActivityComponent;
import com.ben.xplain.dagger.login.LoginActivityModule;
import com.ben.xplain.dagger.main.MainActivityComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangshuhe on 2017/4/11.
 */

@Module(subcomponents = {
        LoginActivityComponent.class,
        MainActivityComponent.class
        },
        includes = {NetModule.class})
public class AppModule {
    private final static String TAG = "AppModule";

    @Provides  Context provideAppContext(XApplication application){
        return application.getBaseContext();
    }

}
