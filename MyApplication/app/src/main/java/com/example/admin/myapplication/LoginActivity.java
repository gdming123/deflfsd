package com.example.admin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.myapplication.Module.AppModule;
import com.example.admin.myapplication.Module.LoginPersenterModule;
import com.example.admin.myapplication.Persenter.LoginPersenter;
import com.example.admin.myapplication.View.LoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity implements LoginView{

    @BindView(R.id.ed_admin)
    EditText ed_admin;

    @BindView(R.id.et_pass)
    EditText et_pass;

    @BindView(R.id.btn_login)
    Button btn_login;
    @Inject
    LoginPersenter loginPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //DaggerLoginPersenterComonent.builder().loginPersenterModule(new LoginPersenterModule(LoginActivity.this,this)).build().inject(this);
         App.getApplication(this).getAppComponent().plus(new LoginPersenterModule(this,this,getInitSDKJson())).inject(this);
        loginPersenter.setLoginView();
        loginPersenter.initSDK();

    }
    @OnClick(R.id.btn_login)
    public void onLogin(View view){
        loginPersenter.Login();
    }


    @Override
    public EditText getAdmin() {
        return ed_admin;
    }

    @Override
    public EditText getPassWord() {
        return et_pass;
    }

    @Override
    public String getInitSDKJson() {
        String S = "{\"id\":\"0\",\"brands\":\"Meizu\",\"deviceModel\":\"1\",\"systemVersion\":\"5.1\",\"deviceResolution\":\"720*1280\",\"imei\":\"86229903865174\",\"meid\":\"86229903865174\",\"mac\":\"\",\"userId\":\"\",\"phoneType\":\"M3s\",\"appId\":\"7\",\"packageName\":\"com.changchong.Cc_Game_SDK\"}";
        return S;
    }


}
