package com.example.themafiagamecards.presentation.screen.rules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themafiagamecards.presentation.event.rules.RulesEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RulesViewModel @Inject constructor(

):ViewModel() {
    private val _uiState = MutableSharedFlow<NavigationEvent>()
    val uiState get() = _uiState.asSharedFlow()

     fun onEvent(event:RulesEvent){
        when(event){
            is RulesEvent.GoToHome -> navigateToHome()
        }
    }
    private fun navigateToHome(){
        viewModelScope.launch {
            _uiState.emit(NavigationEvent.NavigateToHome)
        }
    }
    sealed interface NavigationEvent{
        data object NavigateToHome:NavigationEvent
    }
}