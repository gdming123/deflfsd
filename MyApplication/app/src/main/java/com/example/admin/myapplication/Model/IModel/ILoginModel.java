package com.example.admin.myapplication.Model.IModel;

import android.content.Context;
import android.widget.EditText;

import com.example.admin.myapplication.Net.ApiManager;

/**
 * Created by admin on 2017/3/23.
 */

public interface ILoginModel {

     void Login(EditText admin, EditText password, Context context,ApiManager apiManager);
     void setView(EditText admin , EditText password,Context context);

     void initSDK(String initSdkJson,ApiManager apiManager);
}
