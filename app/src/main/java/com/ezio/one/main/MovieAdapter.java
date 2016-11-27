package com.ezio.one.main;

import android.support.v7.widget.RecyclerView;
import android.text.style.ImageSpan;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ezio.one.R;
import com.ezio.one.main.bean.MovieBean;

import java.util.List;
import java.util.Random;

/**
 * Created by Ezio on 2016/11/27.
 */

public class MovieAdapter extends BaseQuickAdapter<MovieBean, BaseViewHolder> {
    int[] placeholder = new int[]{R.mipmap.movie_placeholder_0, R.mipmap.movie_placeholder_1, R.mipmap.movie_placeholder_2,
            R.mipmap.movie_placeholder_3, R.mipmap.movie_placeholder_4};

    public MovieAdapter(List<MovieBean> data) {
        super(R.layout.item_movie, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MovieBean bean) {
        ImageView imageView = baseViewHolder.getView(R.id.imageView);
        int index = new Random().nextInt(5);
        Glide.with(mContext).load(bean.getCover()).placeholder(placeholder[index]).into(imageView);

    }
}
