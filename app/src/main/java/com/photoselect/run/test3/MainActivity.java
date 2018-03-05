package com.photoselect.run.test3;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MAC on 2018/3/2.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private MainFragment fragment, fragment1, fragment2;
    private MainFragment1 fragment3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        fragment = new MainFragment();
        fragment1 = new MainFragment();
        fragment2 = new MainFragment();
        fragment3 = new MainFragment1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout, fragment);
        fragmentTransaction.add(R.id.framelayout, fragment3);
        fragmentTransaction.add(R.id.framelayout, fragment2);
        fragmentTransaction.show(fragment);
        fragmentTransaction.hide(fragment3);
        fragmentTransaction.hide(fragment2);
        fragmentTransaction.commit();

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.tv1:
                fragmentTransaction.show(fragment);
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment2);
                break;
            case R.id.tv2:
                fragmentTransaction.show(fragment3);
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment2);
                break;
            case R.id.tv3:
                fragmentTransaction.show(fragment2);
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment);
                break;
        }
        fragmentTransaction.commit();
    }
}
