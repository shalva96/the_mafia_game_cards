package com.example.themafiagamecards.presentation.event

sealed class SplashEvent {
    data object NavigateToMain: SplashEvent()
}