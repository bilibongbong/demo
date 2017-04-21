package com.ben.xplain.dagger.main;

import com.ben.xplain.dagger.login.LoginActivityModule;
import com.ben.xplain.login.LoginActivity;
import com.ben.xplain.main.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by wangshuhe on 2017/4/11.
 */
@Subcomponent
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }
}
