package com.example.completeexample.di.modules

import com.example.completeexample.data.local.db.ImageDao
import com.example.completeexample.data.remote.ApiService
import com.example.completeexample.data.repositories.DataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesDataRepository(apiService: ApiService, imageDao: ImageDao): DataRepository {
        return DataRepository(apiService, imageDao)
    }

}