package com.example.admin.myapplication.Net;

import android.app.Application;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * 错误统一处理
 *
 * Created by wanglj on 16/7/4.
 */

public class ExceptionSubscriber<T> extends Subscriber<T> {

    private SimpleCallback<T> simpleCallback;
    private Application app;

    public ExceptionSubscriber(SimpleCallback simpleCallback, Application app){
        this.simpleCallback = simpleCallback;
        this.app = app;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(simpleCallback != null)
            simpleCallback.onStart();
    }

    @Override
    public void onCompleted() {
        if(simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
           Toast.makeText(app, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
           Toast.makeText(app, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
           Toast.makeText(app, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if(simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onNext(T t) {
        if(simpleCallback != null)
            simpleCallback.onNext(t);
    }
}
