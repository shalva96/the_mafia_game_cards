package com.example.themafiagamecards.domain.model

import android.graphics.drawable.Drawable
import java.util.UUID

data class GetRole(
    val id: UUID = UUID.randomUUID(),
    val role: String,
    val color: Int,
    val image: Drawable,
    val title: String,
    val description: String

)
