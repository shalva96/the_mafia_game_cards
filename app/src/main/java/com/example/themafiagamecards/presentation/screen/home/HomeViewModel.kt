package com.example.themafiagamecards.presentation.screen.home

import android.util.Log.d
import androidx.lifecycle.ViewModel
import com.example.themafiagamecards.R
import com.example.themafiagamecards.domain.usecase.GetRoleUseCase
import com.example.themafiagamecards.presentation.model.home_category.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoleUseCase: GetRoleUseCase
) : ViewModel() {
    val categoryList = listOf(
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

    fun get() {

    }

}