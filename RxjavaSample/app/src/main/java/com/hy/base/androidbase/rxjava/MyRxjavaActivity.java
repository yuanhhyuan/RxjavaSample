package com.hy.base.androidbase.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hy.AndroidBase.R;
import com.hy.mylib.rxjava.MyObers;
import com.hy.mylib.rxjava.MyObers1;

public class MyRxjavaActivity extends AppCompatActivity {

    MyObers myObers = new MyObers();
    MyObers1 myObers1 = new MyObers1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrxjava);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObers1.startSubscribe1();
            }
        });

        Button btn21 = (Button) findViewById(R.id.btn21);
        btn21.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObers1.startSubscribe21();
            }
        });

        Button btn22 = (Button) findViewById(R.id.btn22);
        btn22.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObers1.startSubscribe22();
            }
        });

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObers1.justTest();
            }
        });

        Button test1 = (Button) findViewById(R.id.test1);
        test1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObers.test1();
            }
        });

        Button test2 = (Button) findViewById(R.id.test2);
        test2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObers.test2();
            }
        });



    }


}
