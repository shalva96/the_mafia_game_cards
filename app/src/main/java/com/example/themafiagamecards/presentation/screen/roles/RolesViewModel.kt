package com.example.themafiagamecards.presentation.screen.roles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themafiagamecards.R
import com.example.themafiagamecards.domain.usecase.GetRoleUseCase
import com.example.themafiagamecards.presentation.event.roles.RolesEvent
import com.example.themafiagamecards.presentation.mapper.toPresentation
import com.example.themafiagamecards.presentation.model.Role
import com.example.themafiagamecards.presentation.model.home_category.Category
import com.example.themafiagamecards.presentation.screen.state.home.HomeState
import com.example.themafiagamecards.presentation.screen.state.roles.RolesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(
    private val getRoleUseCase: GetRoleUseCase
) :ViewModel() {
    private val _rolesState = MutableStateFlow(RolesState())
    val rolesState get() = _rolesState.asStateFlow()

    private val _uiState = MutableSharedFlow<NavigationEvent>()
    val uiState get() = _uiState.asSharedFlow()

    fun onEvent(event:RolesEvent){
        when(event){
            is RolesEvent.GoToHome -> navigateToHome()
            is RolesEvent.GetRolesList -> rolesList()
        }
    }

    private fun navigateToHome(){
        viewModelScope.launch {
            _uiState.emit(NavigationEvent.NavigateToHome)
        }
    }

    private fun rolesList(){
        viewModelScope.launch{
            _rolesState.update {state ->
                state.copy(
                    button = getRoleUseCase.invoke().map {
                        it.toPresentation()
                    }
                )
            }
        }
    }



    sealed interface NavigationEvent{
        data object NavigateToHome:NavigationEvent
    }
}