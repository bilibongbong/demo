package com.ben.xplain.dagger.login;

import com.ben.xplain.login.LoginActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by wangshuhe on 2017/4/11.
 */
@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent extends AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginActivity>{

    }
}
