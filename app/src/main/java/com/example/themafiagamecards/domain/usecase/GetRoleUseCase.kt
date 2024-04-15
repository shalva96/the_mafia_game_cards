package com.example.themafiagamecards.domain.usecase

import com.example.themafiagamecards.domain.repository.RoleDataRepository
import javax.inject.Inject

class GetRoleUseCase @Inject constructor(
    private val roleDataRepository: RoleDataRepository
) {
    operator fun invoke() = roleDataRepository.getRoleData()
}