package com.ben.xplain.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class XActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    public static final String TAG = "XActivityLifecycleCallback";
    private boolean foreground = false;
    private List<Listener> listeners = new CopyOnWriteArrayList<Listener>();


    private final static class LifecycleCallbackHolder{
        private final static  XActivityLifecycleCallback instance = new XActivityLifecycleCallback();
    }

    public static synchronized XActivityLifecycleCallback init(Application application) {
        application.unregisterActivityLifecycleCallbacks(LifecycleCallbackHolder.instance);
        application.registerActivityLifecycleCallbacks(LifecycleCallbackHolder.instance);
        return LifecycleCallbackHolder.instance;
    }

    public static XActivityLifecycleCallback get() {
        return LifecycleCallbackHolder.instance;
    }

    public boolean isForeground() {
        return foreground;
    }

    public boolean isBackground() {
        return !foreground;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        foreground = true;

        for (Listener l : listeners) {
            try {
                l.onBecameForeground(activity);
            } catch (Exception exc) {

            }
        }

    }

    @Override
    public void onActivityPaused(Activity activity) {
        foreground = false;

        for (Listener l : listeners) {
            try {
                l.onBecameBackground(activity);
            } catch (Exception exc) {
            }
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    public interface Listener {

        public void onBecameForeground(Activity activity);

        public void onBecameBackground(Activity activity);

    }
}