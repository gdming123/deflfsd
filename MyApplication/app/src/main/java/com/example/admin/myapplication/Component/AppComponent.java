package com.example.admin.myapplication.Component;

import com.example.admin.myapplication.Module.ApiModule;
import com.example.admin.myapplication.Module.AppModule;
import com.example.admin.myapplication.Module.LoginPersenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by admin on 2017/3/27.
 */
@Singleton
@Component(modules = {AppModule.class,ApiModule.class})
public interface AppComponent {
    LoginPersenterComonent plus(LoginPersenterModule loginPersenterModule);
}
