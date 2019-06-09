package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 22:04
 * 描述：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(AiniLayout());
        AiniView();
        AiniData();
        AiniListener();
    }

    protected abstract int AiniLayout();

    protected abstract void AiniView();

    protected abstract void AiniData();

    protected abstract void AiniListener();

    public <T extends View> T fg(int ing){
        return (T) findViewById(ing);
    }
}
