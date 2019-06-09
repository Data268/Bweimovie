package com.bawei.bweicinema;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.bawei.guidefragment.Item_FourFragment;
import com.bawei.guidefragment.Item_OneFragment;
import com.bawei.guidefragment.Item_ThreeFragment;
import com.bawei.guidefragment.Item_TwoFragment;
import com.bawei.adapter.GuidePagerAdapter;
import com.bawei.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {
    private ViewPager pager;
    private RadioGroup radio;
    List<Fragment> list=new ArrayList<>();
    private GuidePagerAdapter adapter;
    private Button loginbt;
    private SharedPreferences two;

    //布局
    @Override
    protected int AiniLayout() {
        return R.layout.activity_guide;
    }
    //控件
    @Override
    protected void AiniView() {
        pager=fg(R.id.pager);
        radio=fg(R.id.radio);
        loginbt=fg(R.id.loginbt);
    }
    //数据
    @Override
    protected void AiniData() {
        //先常见sp存值
        two = getSharedPreferences("two", MODE_PRIVATE);
        boolean twoflay = two.getBoolean("twoflay", false);
        if (twoflay){
            //进入登录页面
            Intent intent = new Intent(GuideActivity.this,LoginShowActivity.class);
            startActivity(intent);
            finish();
        }
        //创建集合
        list.add(new Item_OneFragment());
        list.add(new Item_TwoFragment());
        list.add(new Item_ThreeFragment());
        list.add(new Item_FourFragment());
        //创建一个适配器
        adapter = new GuidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(adapter);
        //滑动事件
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                radio.check(radio.getChildAt(position).getId());
                // 判断是否是最后一页
                if (position == list.size() - 1) {
                    loginbt.setVisibility(View.VISIBLE);
                } else {
                    loginbt.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //点击事件
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt1:
                        pager.setCurrentItem(0,true);
                        break;
                    case R.id.bt2:
                        pager.setCurrentItem(1,true);
                        break;
                    case R.id.bt3:
                        pager.setCurrentItem(2,true);
                        break;
                    case R.id.bt4:
                        pager.setCurrentItem(3,true);
                        break;
                }
            }
        });

    }
    //监听
    @Override
    protected void AiniListener() {
        //进入点击
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = two.edit();
                edit.putBoolean("twoflay",true);
                edit.commit();
                //进入登录页面
                Intent intent = new Intent(GuideActivity.this,LoginShowActivity.class);
                startActivity(intent);
                finish();
                //
            }
        });
    }
}
