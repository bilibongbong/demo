package com.ben.xplain.base.UI;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasDispatchingSupportFragmentInjector;

/**
 * Created by wangshuhe on 2017/4/13.
 */
public class XDaggrBaseFragment extends XBaseFragment implements HasDispatchingSupportFragmentInjector{
    private final static String TAG = "XDaggrBaseFragment";
    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }
}
