package com.example.admin.myapplication.Net;


import com.example.admin.myapplication.Bean.BaseResponse;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by wanglj on 16/7/4.
 */

public class BaseResponseFunc<T> implements Func1<BaseResponse<T>, Observable<T>> {


    @Override
    public Observable<T> call(BaseResponse<T> tBaseResponse) {
        //遇到非200错误统一处理,将BaseResponse转换成您想要的对象
        String s = tBaseResponse.toString();
        if (!tBaseResponse.getErrinfo().equals("")) {
            return Observable.error(new Throwable(tBaseResponse.getErrinfo()));
        }else{
            return Observable.just(tBaseResponse.getResult());
        }
    }
}
