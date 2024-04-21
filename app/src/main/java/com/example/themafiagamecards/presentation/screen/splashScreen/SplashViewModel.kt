package com.example.themafiagamecards.presentation.screen.splashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

) : ViewModel() {
    private val _uiEvent = MutableSharedFlow<SplashUiEvent>()
    val uiEvent: SharedFlow<SplashUiEvent> get() = _uiEvent.asSharedFlow()

    //    init {
//        navigationDuration()
//    }
    fun navigationDuration() {
        viewModelScope.launch {
            _uiEvent.emit(SplashUiEvent.NavigateToHome)
        }
    }

    sealed interface SplashUiEvent {
        data object NavigateToHome : SplashUiEvent
    }
}