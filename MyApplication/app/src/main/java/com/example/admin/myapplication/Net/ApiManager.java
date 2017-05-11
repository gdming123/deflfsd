package com.example.admin.myapplication.Net;

import android.app.Application;

import com.example.admin.myapplication.Bean.Result;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/3/24.
 */

public class ApiManager {

    private final ApiService apiService;

    private final Application application;

    public ApiManager(ApiService apiService, Application application) {
        this.apiService = apiService;
        this.application = application;
    }

    public void login(String username, String password, SimpleCallback<Result> simpleCallback) {


        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("loginName", username);
            jsonObject.put("password", password);
            jsonObject.put("imei", "212");
            jsonObject.put("appId", "21");
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
            apiService.login(requestBody)
                    .flatMap(new BaseResponseFunc<Result>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ExceptionSubscriber<Result>(simpleCallback, application));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void initSDK(String json, SimpleCallback<Result> simpleCallback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        apiService.initSDK(requestBody)
                .flatMap(new BaseResponseFunc<Result>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ExceptionSubscriber<Result>(simpleCallback, application));
    }
}
