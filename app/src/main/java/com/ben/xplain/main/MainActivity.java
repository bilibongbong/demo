package com.ben.xplain.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.ben.xplain.base.UI.XDaggerBaseActivity;
import com.ben.xplain.main.view.ActivityListAdapter;
import com.ben.xplain.profile.ProfileActivity;
import com.ben.xplain.R;
import com.ben.xplain.base.UI.XBaseActivity;
import com.ben.xplain.login.LoginActivity;
import com.ben.xplain.search.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends XDaggerBaseActivity {
    @BindView(R.id.activity_list)
    RecyclerView activityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        activityList.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));

        ActivityListAdapter activityListAdapter = new ActivityListAdapter();
        activityList.setAdapter(activityListAdapter);

        activityListAdapter
                .addItem(ProfileActivity.class)
        .addItem(LoginActivity.class)
        .addItem(SearchActivity.class);
    }

    @Override
    public void setActionBar() {
        setActivityTitle(stringFromJNI());
    }

    @Override
    public void initView() {
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
