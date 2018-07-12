package com.hy.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hy.AndroidBase.R;
import com.hy.base.androidbase.rxjava.MyRxjavaActivity;
import com.hy.designpatterns.observer.ObserverActivity;


public class AndroidbaseActivity extends Activity {
    Button jumptrxjava;
    Button mobserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidbase);


        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView(){
        jumptrxjava = (Button) findViewById(R.id.jumptrxjava);
        mobserver = (Button) findViewById(R.id.mobserver);
    }

    private void initListener(){
        jumptrxjava.setOnClickListener(new MyListener());
        mobserver.setOnClickListener(new MyListener());

    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.jumptrxjava:
                    newMyRxjavaActivity();
                    break;
                case R.id.mobserver:
                    newObserverActivity();
                    break;
                default:
                    break;
            }
        }
    }


    private void newMyRxjavaActivity(){
        Intent i = new Intent(AndroidbaseActivity.this,MyRxjavaActivity.class);
        startActivity(i);
    }
    private void newObserverActivity(){
        Intent i = new Intent(AndroidbaseActivity.this,ObserverActivity.class);
        startActivity(i);
    }
}
