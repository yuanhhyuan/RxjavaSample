package com.hy.designpatterns.observer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hy.AndroidBase.R;

import java.util.Observable;

/**
 * java自带的观察者模式
 */
public class ObserverActivity extends Activity {
    TextView showchange;
    int change = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        showchange = findViewById(R.id.showchange);

        Button change0 = findViewById(R.id.change0);
        change0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //被观察者数据改变，更新数据；并通知观察者
                Data mData = new Data();
                mData.setData(change++);
                DataChange.getInstance().notifyDataChange(mData);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //被观察者添加观察者订阅
        DataChange.getInstance().addObserver(watcher);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //观察者从被观察者队列中移除
        DataChange.getInstance().deleteObserver(watcher);
    }

    private DataWatcher watcher = new DataWatcher() {
        @Override
        public void update(Observable observable, Object data) {
            super.update(observable, data);

            //观察者接受到被观察者的通知，来更新自己的数据操作。
            Data mData = (Data) data;
            Log.e("060", "mData---->>" + mData.getData() + ", threadid---->>" + Thread.currentThread().getId());

            showchange.setText(mData.getData() + "");
        }

    };

}
