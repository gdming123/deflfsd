package com.example.admin.myapplication.Net;

/**
 * Created by wanglj on 16/7/4.
 */

public interface SimpleCallback<T> {
    void onStart();
    void onNext(T t);
    void onComplete();
}
