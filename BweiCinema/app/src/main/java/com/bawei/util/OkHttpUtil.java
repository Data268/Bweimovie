package com.bawei.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 21:47
 * 描述：
 */
public class OkHttpUtil {
    private Retrofit retrofit;
    private static OkHttpUtil getin;
    public OkHttpUtil (){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient build = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .callTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)//添加日志
                .build();
        retrofit=new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/")
                .client(build)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
    //创建单例模式
    public static OkHttpUtil in(){
        if (getin == null) {
            getin=new OkHttpUtil();
        }
        return getin;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
