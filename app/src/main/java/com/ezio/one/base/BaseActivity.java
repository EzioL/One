package com.ezio.one.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ezio.one.AppContext;


public class BaseActivity extends AppCompatActivity {

    public AppContext getAppContext() {
        return (AppContext) getApplication();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatus();

    }
    private void setStatus() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            // window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    public void initToolbar(String title, boolean showBack, String text) {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
//        TextView textRight = (TextView) findViewById(R.id.text_toolbar_right);
//        //toolbarTitle.setCompoundDrawables(null, null, null, null);
//        toolbarTitle.setText(title);
//        if (showBack) {
//            toolbar.setNavigationIcon(R.drawable.title_back);
//        }
//        if (text != null && !text.equals("")) {
//            textRight.setText(text);
//            textRight.setVisibility(View.VISIBLE);
//        }
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });
    }

    public void initToolbarWithSearch(String title, String text) {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
//        TextView textRight = (TextView) findViewById(R.id.text_toolbar_right);
//        toolbarTitle.setText(title);
//        toolbar.setNavigationIcon(R.mipmap.search);
//
//        if (text != null && !text.equals("")) {
//            textRight.setText(text);
//            textRight.setVisibility(View.VISIBLE);
//        }
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //
//
//            }
//        });
    }
    public void setToolbarTitle(String title){
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
//        toolbarTitle.setText(title);
    }

}
