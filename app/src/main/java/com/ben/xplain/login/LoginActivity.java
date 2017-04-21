package com.ben.xplain.login;

import android.os.Bundle;
import android.util.Log;

import com.ben.xplain.R;
import com.ben.xplain.base.UI.XDaggerBaseActivity;
import com.ben.xplain.login.presenter.LoginPresenter;
import com.ben.xplain.util.XBottomSheetDialog;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangshuhe on 2017/4/11.
 */
public class LoginActivity extends XDaggerBaseActivity{
    private final static String TAG = "LoginActivity";

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(final ObservableEmitter<Object> e) throws Exception {
                Observable.timer(400, TimeUnit.MILLISECONDS)
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                e.onNext("timer");
                                e.onComplete();
                            }
                        });
            }
        }).ambWith(Observable.timer(500, TimeUnit.MILLISECONDS))
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Log.v(TAG, o == null ? "null":o.toString());
            }
        });


        Observable.timer(500, TimeUnit.MILLISECONDS)
                .ambWith(Observable.create(new ObservableOnSubscribe<Long>() {
                    @Override
                    public void subscribe(final ObservableEmitter<Long> e) throws Exception {
                        Observable.timer(450, TimeUnit.MILLISECONDS)
                                .subscribeOn(AndroidSchedulers.mainThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long aLong) throws Exception {
                                        e.onNext(50L);
                                        e.onComplete();
                                    }
                                });
                    }
                }))
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.v(TAG, aLong.toString());
            }
        });

        XBottomSheetDialog dialog = new XBottomSheetDialog(this);
        dialog.setDatas(new String[]{"abc", "def"});
        dialog.show();
    }

    @Override
    public void setActionBar() {

    }

    @Override
    public void initView() {
        presenter.login();
    }
}
