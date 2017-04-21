package com.ben.xplain.base.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ben.xplain.R;
import com.ben.xplain.app.XApplication;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by benjackson.wang on 2017/3/12.
 */
public abstract class XBaseActivity extends AppCompatActivity {

    protected String TAG = this.getClass().getSimpleName();
    private LinearLayout contentView = null;
    private Toolbar mToolbar;
    private TextView toolbarTitle;
    private TextView amRightTv;
    private Toolbar.OnMenuItemClickListener onMenuItemClickListener;
    private int menuRes = INVALID_MENU;
    private static final int INVALID_MENU = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        if (contentView == null && R.layout.base_activity == layoutResID) {
            super.setContentView(R.layout.base_activity);
            contentView = (LinearLayout) findViewById(R.id.layout_center);
            toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
            amRightTv = (TextView) findViewById(R.id.am_right_tv);
            contentView.removeAllViews();

        } else if (layoutResID != R.layout.base_activity) {
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView, new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            initView();

            //不要改变下面三者的顺序
            beforeSetActionBar();
            setActionBar();
            afterSettingActionBar();

        }
    }

    public void beforeSetActionBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.btn_back);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("");
        mToolbar.setEnabled(true);
    }

    private void afterSettingActionBar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            //隐藏标题栏
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public abstract void setActionBar();

    public abstract void initView();

    public void setMenuId(@MenuRes int menuRes) {
        this.menuRes = menuRes;
    }

    public void setMenu(@MenuRes int menuRes, Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.menuRes = menuRes;
        setMenuClickListener(onMenuItemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuRes != INVALID_MENU) {
            getMenuInflater().inflate(menuRes, menu);
        }
        return true;
    }

    public void setLeftImg(@DrawableRes int imgId) {
        mToolbar.setNavigationIcon(imgId);
    }

    public void setActivityTitle(String text) {
        toolbarTitle.setText(text);
    }

    public void setActivityTitle(@StringRes int textId) {
        toolbarTitle.setText(textId);
    }

    public void setRightText(String text) {
        amRightTv.setText(text);
    }

    public void setRight(String text, View.OnClickListener listener) {
        amRightTv.setText(text);
        amRightTv.setOnClickListener(listener);
    }

    public void setRight(@StringRes int textId) {
        amRightTv.setText(textId);
    }

    public void setRightImg(@DrawableRes int imgId) {
        amRightTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, imgId, 0);
    }

    public void setMenuClickListener(Toolbar.OnMenuItemClickListener clickListener) {
        this.onMenuItemClickListener = clickListener;
    }

    public void setOnNavigationClickListener(View.OnClickListener onNavigationClickListener) {
        mToolbar.setNavigationOnClickListener(onNavigationClickListener);
    }

    public XApplication getXApplication(){
        return (XApplication) getApplication();
    }
}