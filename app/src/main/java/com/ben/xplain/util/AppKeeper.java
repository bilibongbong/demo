package com.ben.xplain.util;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by wangshuhe on 2017/4/14.
 */
public class AppKeeper extends Service {
    private final static String TAG = "AppKeeper";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
