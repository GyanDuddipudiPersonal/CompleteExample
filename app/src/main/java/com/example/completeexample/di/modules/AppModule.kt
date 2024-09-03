package com.example.completeexample.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.completeexample.CompleteApplication
import com.example.completeexample.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: CompleteApplication) {

    @Provides
    @Singleton
    @ApplicationContext
    fun providesContext(completeApplication: CompleteApplication): Context = application.applicationContext

}