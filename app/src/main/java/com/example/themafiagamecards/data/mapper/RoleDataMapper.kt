package com.example.themafiagamecards.data.mapper

import com.example.themafiagamecards.data.model.RoleData
import com.example.themafiagamecards.domain.model.GetRole

fun RoleData.toDomain() =
    GetRole(
        id = id,
        role = role,
        image = image,
        title = title,
        description = description
    )