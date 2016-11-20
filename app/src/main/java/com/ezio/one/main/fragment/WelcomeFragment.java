package com.ezio.one.main.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ezio.one.R;
import com.ezio.one.common.LazyLoadFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ezio on 2016/11/20.
 */

public class WelcomeFragment extends LazyLoadFragment {
    @Bind(R.id.image)
    ImageView image;

    public static final int SPACING = 150;
    public static final String INDEX = "index";
    int welcome_index = 0;
    int welcome_page= 0;
    View view;

    public static WelcomeFragment newInstance(int i) {

        Bundle args = new Bundle();
        args.putInt(INDEX, i);
        WelcomeFragment fragment = new WelcomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            welcome_page = getArguments().getInt(INDEX);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, view);
        lazyLoad();
        image.setBackgroundResource(R.drawable.welcome_ad);
        AnimationDrawable animation = (AnimationDrawable) image.getBackground();
        animation.start();
        return view;
    }

    @Override
    protected void lazyLoad() {
//        welcome_index = 0;
//        handler.postDelayed(runnable, SPACING);

    }

    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (setImage()){
                handler.postDelayed(this, SPACING);
            }

        }
    };
    private boolean setImage() {
        if (welcome_index < welcome.length){
            Glide.with(getActivity()).load(welcome[welcome_index]).into(image);
            welcome_index++;
            return true;
        }else {
            return false;
        }
    }
    int[] welcome = {
            R.mipmap.one_guide_1,R.mipmap.one_guide_2,R.mipmap.one_guide_3,R.mipmap.one_guide_4, R.mipmap.one_guide_5,
            R.mipmap.one_guide_6,R.mipmap.one_guide_7,R.mipmap.one_guide_8,R.mipmap.one_guide_9,R.mipmap.one_guide_10,
            R.mipmap.one_guide_11,R.mipmap.one_guide_12,R.mipmap.one_guide_13,R.mipmap.one_guide_14, R.mipmap.one_guide_15,
            R.mipmap.one_guide_16,R.mipmap.one_guide_17,R.mipmap.one_guide_18,R.mipmap.one_guide_19,R.mipmap.one_guide_20,
            R.mipmap.one_guide_21,R.mipmap.one_guide_22,R.mipmap.one_guide_23,R.mipmap.one_guide_24, R.mipmap.one_guide_25,
            R.mipmap.one_guide_26,R.mipmap.one_guide_27,R.mipmap.one_guide_28,R.mipmap.one_guide_29,R.mipmap.one_guide_30,
            R.mipmap.one_guide_31,R.mipmap.one_guide_32,R.mipmap.one_guide_33,R.mipmap.one_guide_34, R.mipmap.one_guide_35,
            R.mipmap.one_guide_36,R.mipmap.one_guide_37,R.mipmap.one_guide_38,R.mipmap.one_guide_39,R.mipmap.one_guide_40,
            R.mipmap.one_guide_41,R.mipmap.one_guide_42,R.mipmap.one_guide_43,R.mipmap.one_guide_44,R.mipmap.one_guide_45,
            R.mipmap.one_guide_46,R.mipmap.one_guide_47,R.mipmap.one_guide_48,R.mipmap.one_guide_49,R.mipmap.one_guide_50,
            R.mipmap.one_guide_51,R.mipmap.one_guide_52,R.mipmap.one_guide_53,R.mipmap.one_guide_54,R.mipmap.one_guide_55,
            R.mipmap.one_guide_56,R.mipmap.one_guide_57,R.mipmap.one_guide_58,R.mipmap.one_guide_59,R.mipmap.one_guide_60,
            R.mipmap.one_guide_61,R.mipmap.one_guide_62,R.mipmap.one_guide_63,R.mipmap.one_guide_64, R.mipmap.one_guide_65,
            R.mipmap.one_guide_66,R.mipmap.one_guide_67,R.mipmap.one_guide_68,R.mipmap.one_guide_69,R.mipmap.one_guide_70,
            R.mipmap.one_guide_71,R.mipmap.one_guide_72,R.mipmap.one_guide_73,R.mipmap.one_guide_74, R.mipmap.one_guide_75,
            R.mipmap.one_guide_76,R.mipmap.one_guide_77,R.mipmap.one_guide_78,R.mipmap.one_guide_79,R.mipmap.one_guide_80,
            R.mipmap.one_guide_81,R.mipmap.one_guide_82,R.mipmap.one_guide_83,R.mipmap.one_guide_84, R.mipmap.one_guide_85,
            R.mipmap.one_guide_86,R.mipmap.one_guide_87,R.mipmap.one_guide_88,R.mipmap.one_guide_89,R.mipmap.one_guide_90,
            R.mipmap.one_guide_91,R.mipmap.one_guide_92,R.mipmap.one_guide_93,R.mipmap.one_guide_94
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }




}
