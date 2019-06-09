package com.bawei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 佀常勇
 *
 * @Data:2019/6/9 16:45
 * 描述：
 */
public class GuidePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public GuidePagerAdapter(FragmentManager fm, List<Fragment> list) {
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
