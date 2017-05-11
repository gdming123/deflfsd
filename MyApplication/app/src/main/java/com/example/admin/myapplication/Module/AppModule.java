package com.example.admin.myapplication.Module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2017/3/27.
 */
@Module
public class AppModule {
    private final Application app;


    public AppModule(Application app){
        this.app =app;
    }
    @Singleton
    @Provides
    public Application provideApplication(){
        return  app;
    }
}
