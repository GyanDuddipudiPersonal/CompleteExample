package com.example.completeexample.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeexample.viewmodel.CompleteViewModel
import com.example.completeexample.viewmodel.ViewModelFactory
import com.example.completeexample.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CompleteViewModel::class)
    abstract fun bindCompleteViewModel(viewModel: CompleteViewModel): ViewModel
}