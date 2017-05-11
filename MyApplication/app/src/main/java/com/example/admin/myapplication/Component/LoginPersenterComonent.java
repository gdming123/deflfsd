package com.example.admin.myapplication.Component;

import android.content.Context;

import com.example.admin.myapplication.LoginActivity;
import com.example.admin.myapplication.Module.LoginPersenterModule;

import dagger.Subcomponent;

/**
 * Created by admin on 2017/3/27.
 */
@Subcomponent(modules = LoginPersenterModule.class)
public interface LoginPersenterComonent {
    LoginActivity inject( LoginActivity activity);
}
