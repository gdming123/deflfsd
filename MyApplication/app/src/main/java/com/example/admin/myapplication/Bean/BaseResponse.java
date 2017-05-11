package com.example.admin.myapplication.Bean;

/**
 * Created by admin on 2017/3/24.
 */

public class BaseResponse<T> {


    private int ret;

    private String errcode;

    private String errinfo;

    public T result;

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getRet() {
        return this.ret;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrcode() {
        return this.errcode;
    }

    public void setErrinfo(String errinfo) {
        this.errinfo = errinfo;
    }

    public String getErrinfo() {
        return this.errinfo == null ? "" : this.errinfo;
    }

    public void setResult(T result) {

        this.result = result;
    }

    public T  getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "ret=" + ret +
                ", errcode='" + errcode + '\'' +
                ", errinfo='" + errinfo + '\'' +
                ", result=" + result +
                '}';
    }
}
