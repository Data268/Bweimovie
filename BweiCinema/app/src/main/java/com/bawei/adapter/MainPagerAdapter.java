package com.bawei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 佀常勇
 *
 * @Data:2019/6/9 19:41
 * 描述：
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
