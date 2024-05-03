package com.example.themafiagamecards.presentation.screen.home

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themafiagamecards.R
import com.example.themafiagamecards.domain.usecase.GetRoleUseCase
import com.example.themafiagamecards.presentation.event.home.HomeEvents
import com.example.themafiagamecards.presentation.model.home_category.Category
import com.example.themafiagamecards.presentation.screen.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoleUseCase: GetRoleUseCase
) : ViewModel() {
    private val _homeState = MutableStateFlow(HomeState())
    val homeState get() = _homeState.asStateFlow()

    private val _uiState = MutableSharedFlow<NavigationEvent>()
    val uiState get() = _uiState.asSharedFlow()

    fun onEvent(event: HomeEvents) {
        when (event) {
            is HomeEvents.GoToGame -> navigateToGame()
            is HomeEvents.GoToRoles -> navigateToRoles()
            is HomeEvents.GoToRules -> navigateToRules()
            is HomeEvents.GetCategoryList -> categoryList()
        }
    }

    private fun categoryList() {
        viewModelScope.launch {
            _homeState.update { state ->
                state.copy(
                    button = listOf(
                        Category(
                            icon = R.drawable.joystick,
                            title = "Game"
                        ),
                        Category(
                            icon = R.drawable.dices,
                            title = "Roles"
                        ),
                        Category(
                            icon = R.drawable.circle_help,
                            title = "Rules"
                        )
                    )
                )
            }
        }


    }

    private fun navigateToGame() {
        viewModelScope.launch {
            _uiState.emit(NavigationEvent.NavigateToGame)
        }
    }

    private fun navigateToRoles() {
        viewModelScope.launch {
            _uiState.emit(NavigationEvent.NavigateToRoles)
        }
    }

    private fun navigateToRules() {
        viewModelScope.launch {
            _uiState.emit(NavigationEvent.NavigateToRules)
        }
    }

    sealed interface NavigationEvent {
        data object NavigateToGame : NavigationEvent
        data object NavigateToRoles : NavigationEvent
        data object NavigateToRules : NavigationEvent
    }
}
