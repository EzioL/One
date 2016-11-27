package com.ezio.one.service;

import com.ezio.one.base.BaseBean;

import java.util.List;

/**
 * Created by Ezio on 2016/11/20.
 */

public class BaseReposeBean<T>  extends BaseBean {
    private int res;
    private T[] data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}
