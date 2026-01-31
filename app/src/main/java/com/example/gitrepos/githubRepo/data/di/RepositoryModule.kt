package com.example.gitrepos.githubRepo.data.di

import com.example.gitrepos.githubRepo.data.repository.RepoRepositoryImpl
import com.example.gitrepos.githubRepo.domain.repository.RepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepoRepository(
        impl: RepoRepositoryImpl
    ): RepoRepository
}
