package com.example.themafiagamecards.data.repository

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.themafiagamecards.R
import com.example.themafiagamecards.data.mapper.toDomain
import com.example.themafiagamecards.data.model.RoleData
import com.example.themafiagamecards.domain.model.GetRole
import com.example.themafiagamecards.domain.repository.RoleDataRepository
import javax.inject.Inject

class RoleDataRepositoryImpl @Inject constructor(
    private val context: Context
) : RoleDataRepository{
    override fun getRoleData(): List<GetRole> {
        return listOf(
            RoleData(
                role = "Mafia",
                image = ContextCompat.getDrawable(context, R.drawable.ic_launcher_foreground)!!,
                title = "Why Mafia?",
                description = "dsa"
            ),
            RoleData(
                role = "gvbdfsgs",
                image = ContextCompat.getDrawable(context, R.drawable.ic_launcher_foreground)!!,
                title = "Why Mafia?",
                description = "dsa"
            ),
        ).map {
            it.toDomain()
        }
    }
}