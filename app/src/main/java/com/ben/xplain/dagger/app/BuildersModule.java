package com.ben.xplain.dagger.app;

import android.app.Activity;

import com.ben.xplain.dagger.main.MainActivityComponent;
import com.ben.xplain.login.LoginActivity;
import com.ben.xplain.dagger.login.LoginActivityComponent;
import com.ben.xplain.main.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by wangshuhe on 2017/4/12.
 */
@Module
public abstract class BuildersModule {
    private final static String TAG = "BuildersModule";

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
        bindLoginActivityInjectorFactory(LoginActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivityComponent.Builder builder);


}
