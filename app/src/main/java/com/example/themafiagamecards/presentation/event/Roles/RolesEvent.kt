package com.example.themafiagamecards.presentation.event.Roles

import com.example.themafiagamecards.presentation.event.home.HomeEvents

sealed class RolesEvent {
    data object GoToHome: RolesEvent()
}