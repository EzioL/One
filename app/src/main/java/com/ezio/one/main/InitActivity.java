package com.ezio.one.main;

import android.os.Handler;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ezio.one.AppContext;
import com.ezio.one.R;

import com.ezio.one.base.BaseActivity;

public class InitActivity extends BaseActivity {
    private final static int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppContext.getInstance().redirectToActivity(InitActivity.this,WelcomeActivity.class);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
