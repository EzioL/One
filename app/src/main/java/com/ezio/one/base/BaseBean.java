package com.ezio.one.base;

import java.io.Serializable;

/**
 * Created by Ezio on 2016/11/20.
 */

public class BaseBean implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
