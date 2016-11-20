package com.ezio.one.main;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ezio.one.R;
import com.ezio.one.base.BaseActivity;
import com.ezio.one.main.fragment.HomePageFragment;
import com.ezio.one.main.fragment.MovieFragment;
import com.ezio.one.main.fragment.MusicFragment;
import com.ezio.one.main.fragment.ReadingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    int finish ;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.content_main)
    RelativeLayout contentMain;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    private HomePageFragment mHomeFragment;
    private ReadingFragment mReadingFragment;
    private MusicFragment mMusicFragment;
    private MovieFragment mMovieFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        setTitle("首页");

        initFragment();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "不知道实现什么功能...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);



    }

    private void initFragment() {
        //默认显示首页
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        mHomeFragment = HomePageFragment.newInstance();
        ft.add(R.id.content, mHomeFragment).commit();;
        currentFragment = mHomeFragment;
    }

    private void initListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        finish = 0;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (finish < 1){
                Toast.makeText(this, R.string.app_finish, Toast.LENGTH_SHORT).show();
                finish++;
            }else {
                super.onBackPressed();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_main:
                setTitle("首页");
                if (mHomeFragment == null) {
                    mHomeFragment = HomePageFragment.newInstance();
                }
                switchFragment(currentFragment, mHomeFragment);
                break;
            case R.id.nav_reading:
                setTitle("阅读");
                if (mReadingFragment == null) {
                    mReadingFragment = ReadingFragment.newInstance();
                }
                switchFragment(currentFragment, mReadingFragment);
                break;
            case R.id.nav_music:
                setTitle("音乐");
                if (mMusicFragment == null) {
                    mMusicFragment = MusicFragment.newInstance();
                }
                switchFragment(currentFragment, mMusicFragment);
                break;
            case R.id.nav_movie:
                setTitle("电影");
                if (mMovieFragment == null) {
                    mMovieFragment = MovieFragment.newInstance();
                }
                switchFragment(currentFragment, mMovieFragment);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void switchFragment(Fragment from, Fragment to) {
        if (currentFragment != to) {
            currentFragment = to;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                ft.hide(from).add(R.id.content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                ft.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
