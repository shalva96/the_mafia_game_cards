package com.example.themafiagamecards.presentation.event.game

sealed class GameEvent {
    data object GoToHome: GameEvent()
}