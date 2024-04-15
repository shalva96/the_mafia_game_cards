package com.example.themafiagamecards.presentation.model

import android.graphics.drawable.Drawable
import java.util.UUID

data class Role(
    val id: UUID = UUID.randomUUID(),
    val role: String,
    val image: Drawable,
    val title: String,
    val description: String
)
