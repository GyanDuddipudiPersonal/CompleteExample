package com.example.completeexample.di.modules

import android.content.Context
import androidx.room.Room
import com.example.completeexample.data.local.db.AppDataBase
import com.example.completeexample.data.local.db.ImageDao
import com.example.completeexample.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, "images-db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesImagesDao(appDataBase: AppDataBase) : ImageDao = appDataBase.imageDao()
}