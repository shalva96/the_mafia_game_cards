package com.example.themafiagamecards.presentation.screen.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themafiagamecards.presentation.event.game.GameEvent
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
):ViewModel() {
    private val _uiState = MutableSharedFlow<NavigationEvent>()
    val uiState get() = _uiState.asSharedFlow()
    fun onEvent(event: GameEvent){
        when(event){
            is GameEvent.GoToHome -> navigateToHome()
        }
    }
    private fun navigateToHome(){
        viewModelScope.launch {
            _uiState.emit(NavigationEvent.NavigationToHome)
        }
    }

    sealed interface NavigationEvent {
        data object NavigationToHome:NavigationEvent
    }
}