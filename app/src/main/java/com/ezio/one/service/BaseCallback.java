package com.ezio.one.service;

import com.ezio.one.main.bean.MovieBean;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.BaseRequest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Ezio on 2016/11/27.
 */

public abstract class BaseCallback<T> extends AbsCallback<T> {
//
//    @Override
//    public void onBefore(BaseRequest request) {
//        super.onBefore(request);
//        // 主要用于在所有请求之前添加公共的请求头或请求参数
//        // 例如登录授权的 token
//        // 使用的设备信息
//        // 可以随意添加,也可以什么都不传
//        // 还可以在这里对所有的参数进行加密，均在这里实现
//        request.headers("header1", "HeaderValue1")//
//                .params("params1", "ParamsValue1")//
//                .params("token", "3215sdf13ad1f65asd4f3ads1f");
//    }

    /**
     * 该方法是子线程处理，不能做ui相关的工作
     * 主要作用是解析网络返回的 response 对象,生产onSuccess回调中需要的数据对象
     * 这里的解析工作不同的业务逻辑基本都不一样,所以需要自己实现,以下给出的时模板代码,实际使用根据需要修改
     * <pre>
     * OkGo.get(Urls.URL_METHOD)//
     *     .tag(this)//
     *     .execute(new DialogCallback<LzyResponse<ServerModel>>(this) {
     *          @Override
     *          public void onSuccess(LzyResponse<ServerModel> responseData, Call call, Response response) {
     *              handleResponse(responseData.data, call, response);
     *          }
     *     });
     * </pre>
     */

    @Override
    public T convertSuccess(Response response) throws Exception {
        JsonReader jsonReader = new JsonReader(response.body().charStream());
        Type genType = getClass().getGenericSuperclass();
        //从上述的类中取出真实的泛型参数，有些类可能有多个泛型，所以是数值
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        //代码中，只有一个泛型，所以取出第一个，得到如下结果
        Type type = params[0];
        Type rawType = ((ParameterizedType) type).getRawType();

        if (rawType == BaseReposeBean.class) {
            BaseReposeBean reposeBean = BaseConvert.fromJson(jsonReader, type);
            if (reposeBean.getRes() == 0) {
                return (T) reposeBean;
            } else {
                throw new IllegalStateException("请求出错");
            }

        }
        throw new IllegalStateException("基类错误无法解析!");
    }
}
