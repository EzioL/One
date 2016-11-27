package com.ezio.one.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ezio.one.OneApi;
import com.ezio.one.R;
import com.ezio.one.main.MovieAdapter;
import com.ezio.one.service.BaseCallback;
import com.ezio.one.service.BaseReposeBean;
import com.ezio.one.main.bean.MovieBean;
import com.ezio.one.service.BaseConvert;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Ezio on 2016/11/20.
 */

public class MovieFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener {
    private View view;
    private int request_id;
    MovieAdapter mAdapter;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    public static MovieFragment newInstance() {
        Bundle args = new Bundle();
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fagment_movie, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        refreshLayout.setColorSchemeResources(R.color.primary);
        refreshLayout.setOnRefreshListener(this);
        mAdapter = new MovieAdapter(null);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setOnLoadMoreListener(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

        setRefreshing(true);
        loadMoreInfo();
    }

    @Override
    public void onRefresh() {
        request_id = 0;
        loadMoreInfo();
    }

    public void setRefreshing(final boolean refreshing) {
        refreshLayout.post(new Runnable() {
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });
    }
    @Override
    public void onLoadMoreRequested() {
        request_id = mAdapter.getData().get(mAdapter.getData().size()-1).getId();
        loadMoreInfo();
    }

    private void loadMoreInfo() {
        OkGo.get(OneApi.MOIVE_LIST + request_id)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//缓存模式先使用缓存,然后使用网络数据
                .execute(new BaseCallback<BaseReposeBean<MovieBean>>() {
                    @Override
                    public void onSuccess(BaseReposeBean<MovieBean> data, Call call, Response response) {
                        Log.e(TAG, "onSuccess: " + data.getData().toString());
                        List<MovieBean> list =new ArrayList<MovieBean>();
                        for (int i = 0; i < data.getData().length; i++) {
                            list.add(data.getData()[i]);
                        }
                        if (request_id == 0) {
                            setRefreshing(false);
                            mAdapter.setNewData(list);
                        } else {
                            mAdapter.addData(list);
                        }

                        if ( list == null || list.size() == 0) {
                            //数据全部加载完毕
                            mAdapter.loadMoreEnd();
                        }
                    }
                });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
