package com.example.themafiagamecards.presentation.screen.home

import android.util.Log.d
import androidx.lifecycle.ViewModel
import com.example.themafiagamecards.domain.usecase.GetRoleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoleUseCase: GetRoleUseCase
) : ViewModel() {


    fun get() {

        d("getDataFromList", "${ getRoleUseCase.invoke() }")
    }

}