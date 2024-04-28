package com.example.themafiagamecards.presentation.screen.roles

import androidx.lifecycle.ViewModel
import com.example.themafiagamecards.domain.usecase.GetRoleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(
    private val getRoleUseCase: GetRoleUseCase
) :ViewModel() {

}