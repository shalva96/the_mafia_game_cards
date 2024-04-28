package com.example.themafiagamecards.presentation.mapper

import com.example.themafiagamecards.domain.model.GetRole
import com.example.themafiagamecards.presentation.model.Role

fun GetRole.toPresentation() =
    Role(
        id = id,
        role = role,
        color = color,
        image = image,
        title = title,
        description = description

    )