package com.ben.xplain.profile.presenter;

import android.content.Context;
import android.util.Log;

import com.ben.xplain.login.interactor.LoginInteractor;

import javax.inject.Inject;

/**
 * Created by wangshuhe on 2017/4/11.
 */
public class ProfilePresenter {
    private final static String TAG = "LoginPresenter";
    Context mContext;

    @Inject
    ProfilePresenter(Context context){
        mContext = context;
    }

    public void login() {
        Log.v(TAG, "logining");
        mContext.getApplicationInfo();
    }
}
