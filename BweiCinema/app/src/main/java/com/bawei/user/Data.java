package com.bawei.user;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 21:52
 * 描述：
 */
public class Data<T> {
    public String status="-1";
    public String message="请求失败";
    public T result;

    public Data(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
