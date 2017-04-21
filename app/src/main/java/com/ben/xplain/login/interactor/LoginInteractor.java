package com.ben.xplain.login.interactor;

import android.app.Activity;
import android.util.Log;

import javax.inject.Inject;

import dagger.Reusable;

/**
 * Created by wangshuhe on 2017/4/11.
 */
@Reusable
public class LoginInteractor {
    private final static String TAG = "LoginInteractor";
    Activity activity;

    @Inject
    LoginInteractor(Activity activity){
        this.activity = activity;
    }

    public void Log(){
        Log.v(TAG, "logining");
        this.activity.getApplicationInfo();
    }
}
