package com.example.themafiagamecards.di

import android.content.Context
import com.example.themafiagamecards.data.repository.RoleDataRepositoryImpl
import com.example.themafiagamecards.domain.repository.RoleDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRoleDataRepository(@ApplicationContext context: Context) : RoleDataRepository {
       return RoleDataRepositoryImpl(context = context)
    }

}