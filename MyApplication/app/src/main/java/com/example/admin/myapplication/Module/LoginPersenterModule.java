package com.example.admin.myapplication.Module;

import android.content.Context;

import com.example.admin.myapplication.App;
import com.example.admin.myapplication.Component.AppComponent;
import com.example.admin.myapplication.Model.LoginModel;
import com.example.admin.myapplication.Net.ApiManager;
import com.example.admin.myapplication.Persenter.LoginPersenter;
import com.example.admin.myapplication.View.LoginView;


import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2017/3/27.
 */
@Module
public class LoginPersenterModule {
    private final LoginView loginView;
    private Context context;
    private String initsdkJSON;


    public LoginPersenterModule(LoginView loginView, Context context, String initsdkJSON) {

        this.loginView = loginView;
        this.context = context;
        this.initsdkJSON = initsdkJSON;
    }

    @Provides
    public LoginView provideLoginView() {
        return loginView;
    }

    @Provides
    public Context providContext() {
        return context;
    }

    @Provides
    public String providString() {
        return initsdkJSON;
    }

    @Provides
    public LoginModel provideloginModel() {
        return new LoginModel();
    }

    @Provides
    public LoginPersenter provideLoginPersenter(LoginView loginView, Context context, LoginModel loginModel, ApiManager apiManager, String initsdkJSON) {

        return new LoginPersenter(loginView, context, loginModel, apiManager, initsdkJSON);
    }
}
