package com.example.admin.myapplication.Persenter;

import android.content.Context;

import com.example.admin.myapplication.Model.IModel.ILoginModel;
import com.example.admin.myapplication.Model.LoginModel;
import com.example.admin.myapplication.Net.ApiManager;
import com.example.admin.myapplication.View.LoginView;

/**
 * Created by admin on 2017/3/23.
 */

public class LoginPersenter {

    private  ILoginModel loginModel;

    private LoginView loginView;
    private Context context;
    private ApiManager apiManager;
    private String initSDKjson;

    public LoginPersenter(LoginView loginView,Context context,LoginModel loginModel,ApiManager apiManager,String initSDKjson) {
        this.loginView = loginView;
        this.context = context;
        this.loginModel = loginModel;
        this.apiManager = apiManager;
        this.initSDKjson = initSDKjson;
    }

    public void Login() {
        loginModel.Login(loginView.getAdmin(), loginView.getPassWord(),context,apiManager);

    }
    public void setLoginView(){
        loginModel.setView(loginView.getAdmin(),loginView.getPassWord(),context);
    }

    public void initSDK() {
        loginModel.initSDK(initSDKjson,apiManager);
    }
}
