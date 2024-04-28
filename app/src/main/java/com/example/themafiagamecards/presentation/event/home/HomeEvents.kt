package com.example.themafiagamecards.presentation.event.home

sealed class HomeEvents {
    data object GoToGame: HomeEvents()
    data object GoToRoles:HomeEvents()
    data object GoToRules:HomeEvents()
    data object GetCategoryList: HomeEvents()
}