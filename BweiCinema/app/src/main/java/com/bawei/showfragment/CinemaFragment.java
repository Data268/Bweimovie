package com.bawei.showfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bawei.adapter.ComingAdapter;
import com.bawei.adapter.HotAdapter;
import com.bawei.adapter.IsHotAdapter;
import com.bawei.base.BaseFragment;
import com.bawei.bweicinema.R;
import com.bawei.mvp.presenter.ComingPresenter;
import com.bawei.mvp.presenter.HotPresenter;
import com.bawei.mvp.presenter.IsHotPresenter;
import com.bawei.mvp.view.View;
import com.bawei.user.Data;
import com.bawei.user.HotUser;

import java.util.List;

/**
 * 佀常勇
 *
 * @Data:2019/6/9 19:19
 * 描述：
 */
public class CinemaFragment extends BaseFragment {
    private RecyclerView hotrecycler,ishotrecycler,comingrecycler;
    private ImageView hotbt,ishotbt,comingsoonbt;
    private HotPresenter hotPresenter;
    private IsHotPresenter isHotPresenter;
    private ComingPresenter comingPresenter;
    private HotAdapter adapter;
    private IsHotAdapter isHotAdapter;
    private ComingAdapter comingAdapter;

    //布局
    @Override
    protected int FiniLayout() {
        return R.layout.cinemafragment;
    }
    //控件
    @Override
    protected void FiniView() {
        hotrecycler=fg(R.id.hotrecycler);
        ishotrecycler=fg(R.id.ishotrecycler);
        comingrecycler=fg(R.id.comingrecycler);
        hotbt=fg(R.id.hotbt);
        ishotbt=fg(R.id.ishotgbt);
        comingsoonbt=fg(R.id.comingsoonbt);
    }
    //数据
    @Override
    protected void FiniData() {
        //请求热门电影的数据
        hotPresenter = new HotPresenter(new hotdata());
        hotPresenter.getModel(1,"10");

        isHotPresenter = new IsHotPresenter(new ishotdata());
        isHotPresenter.getModel(1,"10");

        comingPresenter = new ComingPresenter(new comingdata());
        comingPresenter.getModel(1,"10");
        //创建适配器
        adapter = new HotAdapter(getContext());
        hotrecycler.setAdapter(adapter);
        hotrecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        isHotAdapter = new IsHotAdapter(getContext());
        ishotrecycler.setAdapter(isHotAdapter);
        ishotrecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        comingAdapter = new ComingAdapter(getContext());
        comingrecycler.setAdapter(comingAdapter);
        comingrecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }
    //热门电影
    class hotdata implements View<List<HotUser>>{
        @Override
        public void success(List<HotUser> listData) {
            adapter.add(listData);
        }
        @Override
        public void fild(Data data) {

        }
    }
    //正在上映
    class ishotdata implements View<List<HotUser>>{
        @Override
        public void success(List<HotUser> listData) {
            isHotAdapter.clear();
            isHotAdapter.add(listData);
        }
        @Override
        public void fild(Data data) {

        }
    }
    //即将上映
    class comingdata implements View<List<HotUser>>{
        @Override
        public void success(List<HotUser> listData) {
            comingAdapter.clear();
            comingAdapter.add(listData);
        }
        @Override
        public void fild(Data data) {

        }
    }
    //监听
    @Override
    protected void FiniListener() {

    }
}
