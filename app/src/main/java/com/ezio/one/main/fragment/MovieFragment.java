package com.ezio.one.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezio.one.OneApi;
import com.ezio.one.R;
import com.ezio.one.base.BaseReposeBean;
import com.ezio.one.main.bean.MovieBean;
import com.ezio.one.utils.Convert;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.callback.StringCallback;

import java.lang.reflect.Type;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Ezio on 2016/11/20.
 */

public class MovieFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private int request_id;
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

    private void loadMoreInfo() {
        OkGo.get(OneApi.MOIVE_LIST + request_id)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//缓存模式先使用缓存,然后使用网络数据
                .execute(new AbsCallback<BaseReposeBean<MovieBean>>() {

                    @Override
                    public BaseReposeBean<MovieBean> convertSuccess(Response response) throws Exception {
                        JsonReader jsonReader = new JsonReader(response.body().charStream());
                        BaseReposeBean<MovieBean> bean = Convert.fromJson(jsonReader, BaseReposeBean.class);
                        response.close();
                        return bean;
                    }

                    @Override
                    public void onSuccess(BaseReposeBean<MovieBean> movieBeanBaseReposeBean, Call call, Response response) {
                        Log.e(TAG, "onSuccess: " + movieBeanBaseReposeBean.toString());
                    }
                });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
