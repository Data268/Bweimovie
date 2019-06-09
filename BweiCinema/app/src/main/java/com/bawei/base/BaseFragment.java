package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 22:01
 * 描述：
 */
public abstract class BaseFragment extends Fragment {
    //创建视图
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(FiniLayout(), container, false);
        return inflate;
    }
    protected abstract int FiniLayout();
    //控件
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FiniView();
    }
    protected abstract void FiniView();
    //数据+监听
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FiniData();
        FiniListener();
    }

    protected abstract void FiniData();

    protected abstract void FiniListener();


    public <T extends View> T fg(int ing){
        return (T)getView().findViewById(ing);
    }
}
