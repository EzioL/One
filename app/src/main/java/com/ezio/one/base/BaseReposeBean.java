package com.ezio.one.base;

import java.util.List;

/**
 * Created by Ezio on 2016/11/20.
 */

public class BaseReposeBean<T>  extends BaseBean {
    private int res;
    private List<T> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
