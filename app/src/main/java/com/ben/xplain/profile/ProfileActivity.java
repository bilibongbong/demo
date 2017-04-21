package com.ben.xplain.profile;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.ben.xplain.R;
import com.ben.xplain.base.UI.XBaseActivity;
import com.ben.xplain.login.presenter.LoginPresenter;

import javax.inject.Inject;

import static android.view.View.VISIBLE;

public class ProfileActivity extends XBaseActivity {
    private EditText editText;
    private Button buttonEdit;

    @Inject
    LoginPresenter presenter;

    private View rootView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutChangeListener;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeKeyboardListener();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editText = (EditText) findViewById(R.id.text_edit);
        buttonEdit = (Button) findViewById(R.id.button_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                manager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
            }
        });

        rootView = findViewById(R.id.activity_root);
        addKeyboardListener();


    }

    private void addKeyboardListener() {
        layoutChangeListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            boolean editing = false;
            @Override
            public void onGlobalLayout() {
                boolean currentEditing = editText.getVisibility() == VISIBLE;
                if ( editing && currentEditing ){
                }
                editing = currentEditing;
            }
        };

        rootView.getViewTreeObserver().addOnGlobalLayoutListener(layoutChangeListener);
    }

    private void removeKeyboardListener() {
        if (Build.VERSION.SDK_INT >= 16  ){
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(layoutChangeListener);
        }
        else {
            rootView.getViewTreeObserver().removeGlobalOnLayoutListener(layoutChangeListener);
        }
    }

    @Override
    public void setActionBar() {
        setActivityTitle("测试");
    }

    @Override
    public void initView() {
        editText = (EditText) findViewById(R.id.text_edit);
    }

}
