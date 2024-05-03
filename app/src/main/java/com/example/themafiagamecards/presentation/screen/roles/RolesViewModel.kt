package com.example.themafiagamecards.presentation.screen.roles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themafiagamecards.domain.usecase.GetRoleUseCase
import com.example.themafiagamecards.presentation.event.Roles.RolesEvent
import com.example.themafiagamecards.presentation.screen.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(
    private val getRoleUseCase: GetRoleUseCase
) :ViewModel() {
    private val _uiState = MutableSharedFlow<NavigationEvent>()
    val uiState get() = _uiState.asSharedFlow()

    fun onEvent(event:RolesEvent){
        when(event){
            is RolesEvent.GoToHome -> navigateToHome()
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