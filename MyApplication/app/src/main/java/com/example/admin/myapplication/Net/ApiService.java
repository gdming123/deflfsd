package com.example.admin.myapplication.Net;

import com.example.admin.myapplication.Bean.BaseResponse;
import com.example.admin.myapplication.Bean.Result;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by admin on 2017/3/24.
 */

public interface ApiService {
    String SERVER_URL = "http://121.43.167.53:8080";

    @POST("/appApi/app/v1/device_start")
    Observable<BaseResponse<Result>> initSDK(@Body RequestBody body);

    @POST("/appApi/app/v1/s_login")
    Observable<BaseResponse<Result>> login(@Body RequestBody body);





}
