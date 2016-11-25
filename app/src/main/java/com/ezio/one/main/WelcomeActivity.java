package com.ezio.one.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.ezio.one.R;
import com.ezio.one.base.BaseActivity;
import com.ezio.one.common.FragmentAdapter;
import com.ezio.one.main.fragment.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter ;
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new WelcomeFragment().newInstance(1));
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragmentAdapter);

    }
}
