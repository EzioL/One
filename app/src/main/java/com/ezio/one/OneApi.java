package com.ezio.one;

/**
 * Created by Ezio on 2016/8/28.
 */

public class OneApi {
    // 服务器地址
    public static final String HOST_URL = "http://v3.wufazhuce.com:8000/api/";
    //首页
    public static final String HOMEPAGE = "hp/";
    // 首页图文列表
    //
    public static final String HOMEPAGE_MORE = "more/0";
    // 月的首页图文列表 bymonth/2016-05
    //date格式为 YYYY-MM-DD 00:00:00 (-DD 00:00:00 可以不填)
    public static final String HOMEPAGE_BYMONTH = "bymonth/";

    //阅读
    public static final String READING = "reading";

    //音乐
    public static final String MUSIC = "music";
    //电影
    public static final String MOVIE = HOST_URL + "movie";
    //list/0  下一页数据page 是上一页最后的数据id
    public static final String MOIVE_LIST = MOVIE + "/list/";

}
