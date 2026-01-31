package com.example.gitrepos.githubRepo.domain.repository

import androidx.paging.PagingData
import com.example.gitrepos.githubRepo.domain.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    fun searchRepos(query: String): Flow<PagingData<Repo>>
}
