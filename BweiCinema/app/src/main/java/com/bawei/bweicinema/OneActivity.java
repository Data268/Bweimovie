package com.bawei.bweicinema;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bawei.base.BaseActivity;

public class OneActivity extends BaseActivity {

    private TextView oneid;
    private int page=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            page--;
            oneid.setText(page+"S");
            handler.sendEmptyMessageDelayed(0,1000);
            if (page==0) {
                handler.removeMessages(0);
                //跳转
                Intent intent = new Intent(OneActivity.this,GuideActivity.class);
                startActivity(intent);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("flay",true);
                edit.commit();
                finish();
            }
        }
    };
    private SharedPreferences sp;

    //首页
    @Override
    protected int AiniLayout() {
        return R.layout.activity_one;
    }
    //控件
    @Override
    protected void AiniView() {
        oneid=fg(R.id.oneid);
    }
    //数据
    @Override
    protected void AiniData() {
        //创建sp存值
        sp = getSharedPreferences("one", MODE_PRIVATE);
        boolean flay = sp.getBoolean("flay", false);
        if (flay) {
            //跳转登录页面
            //跳转
            Intent intent = new Intent(OneActivity.this,GuideActivity.class);
            startActivity(intent);
            finish();
        }else{
            //发送一个时间
            handler.sendEmptyMessageDelayed(0,1000);
        }
    }
    //监听
    @Override
    protected void AiniListener() {

    }
}
