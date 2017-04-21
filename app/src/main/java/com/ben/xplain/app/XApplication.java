package com.ben.xplain.app;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.ben.xplain.dagger.app.DaggerAppComponent;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by benjackson.wang on 2017/3/12.
 */
public class XApplication extends Application implements HasDispatchingActivityInjector{
    private final static String TAG = "XApplication";
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .application(this)
                .build().inject(this);

        XActivityLifecycleCallback.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
