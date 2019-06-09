package com.bawei.mvp.view;

import com.bawei.user.Data;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 21:53
 * 描述：
 */
public interface View<T> {
    void success(T t);
    void fild(Data data);
}
