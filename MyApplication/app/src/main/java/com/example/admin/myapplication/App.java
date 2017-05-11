package com.example.admin.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.admin.myapplication.Component.AppComponent;
import com.example.admin.myapplication.Component.DaggerAppComponent;
import com.example.admin.myapplication.Module.ApiModule;
import com.example.admin.myapplication.Module.AppModule;

/**
 * Created by admin on 2017/3/24.
 */


public class App extends Application {
    public AppComponent appComponent;


    public static App getApplication(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {

        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }
}
