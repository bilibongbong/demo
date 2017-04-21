package com.ben.xplain.dagger.login;

import android.app.Activity;

import com.ben.xplain.login.LoginActivity;

import dagger.Binds;
import dagger.Module;

/**
 * Created by wangshuhe on 2017/4/12.
 */
@Module
public abstract class LoginActivityModule {
    private final static String TAG = "LoginActivityModule";
    @Binds
    abstract Activity provideActivity(LoginActivity activity);
}
