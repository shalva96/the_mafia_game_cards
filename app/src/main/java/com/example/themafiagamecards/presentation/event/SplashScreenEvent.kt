package com.example.themafiagamecards.presentation.event

sealed class SplashScreenEvent {
    data object Navigate : SplashScreenEvent()
}