package com.bawei.mvp.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.mvp.model.IRequest;
import com.bawei.mvp.view.View;

import io.reactivex.Observable;

/**
 * 佀常勇
 *
 * @Data:2019/6/9 20:06
 * 描述：
 */
public class IsHotPresenter extends BasePresenter {

    public IsHotPresenter(View view) {
        super(view);
    }

    @Override
    public Observable getData(IRequest iRequest, Object... ag) {
        return iRequest.ishotshow((int) ag[0],(String) ag[1]);
    }
}
