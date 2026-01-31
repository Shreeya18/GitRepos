package com.example.gitrepos.githubRepo.domain.usecase

import androidx.paging.PagingData
import com.example.gitrepos.githubRepo.domain.Repo
import com.example.gitrepos.githubRepo.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow

class SearchReposUseCase(
    private val repository: RepoRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Repo>> {
        return repository.searchRepos(query)
    }
}
