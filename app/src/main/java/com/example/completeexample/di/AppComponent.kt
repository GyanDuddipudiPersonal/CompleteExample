package com.example.completeexample.di

import com.example.completeexample.CompleteApplication
import com.example.completeexample.di.modules.ActivityBuilderModule
import com.example.completeexample.di.modules.AppModule
import com.example.completeexample.di.modules.DatabaseModule
import com.example.completeexample.di.modules.NetworkModule
import com.example.completeexample.di.modules.RepositoryModule
import com.example.completeexample.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        AppModule::class,
        ViewModelModule::class,
        RepositoryModule::class]
)
interface AppComponent : AndroidInjector<CompleteApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CompleteApplication) : Builder
        fun appModule(appModule: AppModule) : Builder
        fun build() : AppComponent
    }
    override fun inject(application: CompleteApplication)
}