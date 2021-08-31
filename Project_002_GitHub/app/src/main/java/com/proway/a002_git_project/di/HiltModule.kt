package com.proway.a002_git_project.di

import com.proway.a002_git_project.repository.GitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGitRepository() : GitRepository = GitRepository()
}