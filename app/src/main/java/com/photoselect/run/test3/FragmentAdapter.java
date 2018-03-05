package com.photoselect.run.test3;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAC on 2018/3/2.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private FragmentManager fragmentManager;
    private Context context;
    private List<String> list;

    public FragmentAdapter(Context context, FragmentManager fm, List<String> list) {
        super(fm);
        this.fragmentManager = fm;
        this.context = context;
        this.list = new ArrayList<>();
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return new MainFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
