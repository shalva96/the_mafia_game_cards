package com.example.themafiagamecards.presentation.screen.splashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themafiagamecards.presentation.event.SplashEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableSharedFlow<SplashUiEvent>()
    val uiState get() = _uiState.asSharedFlow()


    fun onEvent(event: SplashEvent){
        when(event){
            is SplashEvent.NavigateToMain -> navigateToHome()
        }
    }

    private fun navigateToHome(){
        viewModelScope.launch {
            _uiState.emit(SplashUiEvent.NavigationToHome)
        }
    }

    sealed interface SplashUiEvent {
        data object NavigationToHome: SplashUiEvent
    }
}