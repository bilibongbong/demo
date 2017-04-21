package com.ben.xplain.login.presenter;

import android.content.Context;
import android.util.Log;

import com.ben.xplain.login.interactor.LoginInteractor;

import javax.inject.Inject;

/**
 * Created by wangshuhe on 2017/4/11.
 */
public class LoginPresenter {
    private final static String TAG = "LoginPresenter";
    Context mContext;
    LoginInteractor interactor;

    @Inject
    LoginPresenter(Context context, LoginInteractor interactor){
        mContext = context;
        this.interactor = interactor;
    }

    public void login() {
        Log.v(TAG, "logining");
        mContext.getApplicationInfo();
        interactor.Log();
    }
}
