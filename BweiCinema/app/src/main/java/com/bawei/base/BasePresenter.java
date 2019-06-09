package com.bawei.base;

import com.bawei.mvp.model.IRequest;
import com.bawei.mvp.view.View;
import com.bawei.user.Data;
import com.bawei.util.OkHttpUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 21:54
 * 描述：
 */
public abstract class BasePresenter {
    private View view;

    public BasePresenter(View view) {
        this.view = view;
    }
    public void getModel(Object...ag){
        IRequest iRequest = OkHttpUtil.in().getRetrofit().create(IRequest.class);
        getData(iRequest,ag)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Function<Throwable,Data>() {
                    @Override
                    public Data apply(Throwable o) throws Exception {
                        return new Data("5000",o.getMessage());
                    }
                })
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data o) throws Exception {

                        if (o.status.equals("0000")){
                            if (o.result == null) {
                                view.success(o.message);
                            }else{
                                view.success(o.result);
                            }
                        }else{
                                view.fild(o);
                        }

                    }
                });
    }
    public abstract Observable getData(IRequest iRequest, Object... ag);
    public void onde(){
        if (view != null) {
            view=null;
        }
    }
}
