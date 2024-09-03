package com.example.completeexample

import android.app.Application
import com.example.completeexample.di.DaggerAppComponent
import com.example.completeexample.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CompleteApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).appModule(AppModule(this)).build()
            .inject(this)
    }


    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}