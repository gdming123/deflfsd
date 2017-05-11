package com.example.admin.myapplication.Bean;

/**
 * Created by admin on 2017/3/24.
 */

public class Result {

    private String deviceId;
    private String userId;
    public String data;
    private String resultInfo;
    private Byte isAuth;
    private String resultCode;
    private int time;

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setIsAuth(Byte isAuth) {
        this.isAuth = isAuth;
    }

    public Byte getIsAuth() {
        return this.isAuth;
    }

    @Override
    public String toString() {
        return "Result{" +
                "deviceId='" + deviceId + '\'' +
                ", userId='" + userId + '\'' +
                ", data='" + data + '\'' +
                ", resultInfo='" + resultInfo + '\'' +
                ", isAuth=" + isAuth +
                ", resultCode='" + resultCode + '\'' +
                ", time=" + time +
                '}';
    }
}
