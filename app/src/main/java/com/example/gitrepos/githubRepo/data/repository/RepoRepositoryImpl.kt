package com.example.gitrepos.githubRepo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.gitrepos.githubRepo.data.mapper.toDomain
import com.example.gitrepos.githubRepo.data.remote.api.GithubApi
import com.example.gitrepos.githubRepo.data.remote.paging.RepoPagingSource
import com.example.gitrepos.githubRepo.domain.Repo
import com.example.gitrepos.githubRepo.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RepoRepositoryImpl(
    private val api: GithubApi
) : RepoRepository {

    override fun searchRepos(
        query: String
    ): Flow<PagingData<Repo>> {

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                RepoPagingSource(api, query)
            }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }
}
