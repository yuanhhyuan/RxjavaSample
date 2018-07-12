package com.hy.mylib.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**   
 * 操作符的使用
 */
public class MyObers1 {

    //在 RxJava 的默认规则中，事件的发出和消费都是在同一个线程的

    /**
     *create
     */
    //方式一
    public void startSubscribe1() {  //订阅
        myObservable1.subscribe(mySubscriber1);
    }

    Observable<String> myObservable1 = Observable.create( //被观察者。。create() 方法是 RxJava 最基本的创造事件序列的方法。
            new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> sub) {
                    // TODO:
                    Log.e("060", "myObservable1 thread id : " + Thread.currentThread().getId());
                    sub.onNext("Hello, world!");  // 写回调，传给观察者
                    sub.onCompleted();   //订阅事件全部结束后的回调，传给观察者
                }
            }
    );

    Subscriber<String> mySubscriber1 = new Subscriber<String>() { //观察者
        @Override
        public void onNext(String s) {
            Log.e("060", "mySubscriber1 thread id : " + Thread.currentThread().getId());
            Log.e("010", s + "");
        }

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }
    };


    //方式二
    public void startSubscribe21() {
        myObservable2.subscribe(onNextAction, onErrorAction,onCompleteAction);  //RxJava 还提供了一些方法用来快捷创建事件队列，例如：just(T...): 将传入的参数依次发送出来。
    }

    Observable<String> myObservable2 = Observable.just("Hello, world!");  //被观察者

    //观察者
    Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.e("060", s + ": 21");
        }
    };
    Action1<Throwable> onErrorAction = new Action1<Throwable>() {
        @Override
        public void call(Throwable s) {

        }
    };
    Action0 onCompleteAction = new Action0() {
        @Override
        public void call() {

        }
    };

    //方式三
    public void startSubscribe22() {
        Observable.just("Hello, world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("060", s + ": 22");
                    }
                });
    }


    /**
     * just。参数类型String
     */
    public void justTest() {
        //        Observable<String> observable = Observable.just("hello");
        Observable<String> observable = Observable.just("hello", "my", "nice", "world");
        Subscription subscription = observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("060", "onNext : " + s);
            }
        });
    }

    /**
     * from。参数类型Integer
     */
    public void fromTest() {
        List<Integer> lists = new ArrayList<>();   //from(T[]) / from(Iterable<? extends T>) : 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);

        Observable<Integer> observable = Observable.from(lists);
        Subscription subscription = observable.subscribe(new Observer<Integer>() {

            @Override
            public void onCompleted() {
                Log.i("060", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("060", "onError: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i("060", "onNext : " + integer);
            }
        });
    }

    /**
     * map。
     */
    public void mapTest() {
        Observable.just("Hello, world!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -Dan";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

        Observable.just("Hello")
                .map(new Func1<String, Integer>() {  //Func1<输入, 输出>()
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer s) {
                        System.out.println(s + "");
                    }
                });
    }

    /**
     * flatMap。Observable.flatMap()接收一个Observable的输出作为输入，同时输出另外一个Observable
     */
    public void flatMapTest() {

    }

    /**
     * filter 过滤,把不符合条件的过滤掉,留下符合条件的
     */


    /**
     * take 指定最多输出的数量
     */



}
