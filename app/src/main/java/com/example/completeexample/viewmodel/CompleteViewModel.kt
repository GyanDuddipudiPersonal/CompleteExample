package com.example.completeexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.completeexample.data.model.CustomImage
import com.example.completeexample.data.repositories.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CompleteViewModel @Inject constructor(private val dataRepository: DataRepository) :
    ViewModel() {
    private var _images: MutableStateFlow<List<CustomImage>> = MutableStateFlow(emptyList())
    var images: StateFlow<List<CustomImage>> = _images

    private val _navigationChannel = Channel<NavigationEvent>()
    val navigationChannelFlow = _navigationChannel.receiveAsFlow()

    //    init {
//        fetchImages()
//    }
    fun navigateToScreen(navigationEvent: NavigationEvent) {
        viewModelScope.launch {
            _navigationChannel.send(navigationEvent)
        }
    }

    internal suspend fun fetchImages() {
        _images.value = viewModelScope.async(Dispatchers.IO) {
            dataRepository.getAllImages()
        }.await()
    }

    sealed interface NavigationEvent {
        data object NavigateToScreenTwo : NavigationEvent
        data object NavigateToScreenOne : NavigationEvent
    }
}