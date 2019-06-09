package com.bawei.bweicinema;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.bawei.adapter.MainPagerAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.showfragment.CinemaFragment;
import com.bawei.showfragment.MovieFragment;
import com.bawei.showfragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager showpager;
    private RadioGroup showradio;
    List<Fragment> list=new ArrayList<>();
    private MainPagerAdapter adapter;
    ///佀常勇
    //布局
    @Override
    protected int AiniLayout() {
        return R.layout.activity_main;
    }
    //控件
    @Override
    protected void AiniView() {
        showpager=fg(R.id.showpager);
        showradio=fg(R.id.showradio);
    }
    //数据
    @Override
    protected void AiniData() {
        //添加数据
        list.add(new CinemaFragment());
        list.add(new MovieFragment());
        list.add(new MyFragment());
        //创建适配器
        adapter = new MainPagerAdapter(getSupportFragmentManager(),list);
        showpager.setAdapter(adapter);
        //滑动监听
        showpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                showradio.check(showradio.getChildAt(position).getId());
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        showradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.showbt1:
                        showpager.setCurrentItem(0,false);
                        break;
                    case R.id.showbt2:
                        showpager.setCurrentItem(1,false);
                        break;
                    case R.id.showbt3:
                        showpager.setCurrentItem(2,false);
                        break;
                }
            }
        });
    }
    //监听
    @Override
    protected void AiniListener() {

    }
}
