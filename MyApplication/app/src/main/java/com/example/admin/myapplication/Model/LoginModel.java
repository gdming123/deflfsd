package com.example.admin.myapplication.Model;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myapplication.Bean.Result;
import com.example.admin.myapplication.Model.IModel.ILoginModel;
import com.example.admin.myapplication.Net.ApiManager;
import com.example.admin.myapplication.Net.SimpleCallback;

import static android.R.attr.password;

/**
 * Created by admin on 2017/3/23.
 */

public class LoginModel implements ILoginModel {


    @Override
    public void Login(EditText admin, EditText password, Context context, ApiManager apiManager) {
        Toast.makeText(context, admin.getText().toString() + password.getText().toString(), Toast.LENGTH_SHORT).show();
        apiManager.login(admin.getText().toString(), password.getText().toString(), new SimpleCallback<Result>() {
            @Override
            public void onStart() {
                Log.e("TAG","onStart");
            }


            @Override
            public void onNext(Result result) {
                Log.e("TAG",result.toString());
            }

            @Override
            public void onComplete() {
                Log.e("onComplete","onComplete");
            }
        });
    }

    @Override
    public void setView(EditText admin, EditText password, Context context) {
        admin.setText("122");
        password.setText("456");
    }

    @Override
    public void initSDK(String json, ApiManager apiManager) {
        apiManager.initSDK(json, new SimpleCallback<Result>() {
            @Override
            public void onStart() {
                Log.e("TAG", "onStart");
            }


            @Override
            public void onNext(Result result) {
                Log.e("TAG", result.toString());
            }

            @Override
            public void onComplete() {
                Log.e("onComplete", "onComplete");
            }
        });

    }


}
