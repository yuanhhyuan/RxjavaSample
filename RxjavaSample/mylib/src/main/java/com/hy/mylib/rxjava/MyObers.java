package com.hy.mylib.rxjava;

import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 线程调度的使用
 */
public class MyObers {
    private String tag = "060_MyObers";

    /**
     * 线程控制Scheduler
     */
    public void test1() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())              // 指定subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程。
                .observeOn(AndroidSchedulers.mainThread()) // 指定Subscriber 所运行在的线程。或者叫做事件消费的线程。
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        Log.e(tag, "number:" + number + "; threadid is :" + Thread.currentThread().getId());
                    }
                });
    }

    public void test2() {
        Observable.just("ha1", "ha2", "ha3", "ha4")
                .subscribeOn(Schedulers.io())              // 指定subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程。
                .observeOn(AndroidSchedulers.mainThread()) // 指定Subscriber 所运行在的线程。或者叫做事件消费的线程。
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String str) {
                        Log.e(tag, "str:" + str + "; threadid is :" + Thread.currentThread().getId());
                    }
                });
    }


}
