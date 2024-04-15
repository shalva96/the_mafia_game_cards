package com.example.themafiagamecards.domain.repository

import com.example.themafiagamecards.domain.model.GetRole

interface RoleDataRepository {
    fun getRoleData() : List<GetRole>
}