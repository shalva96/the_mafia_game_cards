package com.example.themafiagamecards.presentation.model.home_category

import java.util.UUID

data class Category(
    val id: UUID = UUID.randomUUID(),
    val icon: Int,
    val title: String
)