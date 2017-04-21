package com.ben.xplain.dagger.app;

import com.ben.xplain.app.XApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by wangshuhe on 2017/4/12.
 */
@Singleton
@Component(modules = {AppModule.class,BuildersModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {
    XApplication app();

    @Component.Builder
    interface Builder{
        @BindsInstance Builder application(XApplication application);
        AppComponent build();
    }

    void inject(XApplication application);
}
