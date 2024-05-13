package com.example.themafiagamecards.presentation.event.roles

sealed class RolesEvent {
    data object GoToHome: RolesEvent()
    data object GetRolesList: RolesEvent()
}