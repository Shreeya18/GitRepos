package com.example.gitrepos.githubRepo.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gitrepos.githubRepo.data.remote.dto.RepoDto
import com.example.gitrepos.githubRepo.data.remote.api.GithubApi

class RepoPagingSource(
    private val api: GithubApi,
    private val query: String
) : PagingSource<Int, RepoDto>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, RepoDto> {
        return try {
            val page = params.key ?: 1

            val response = api.searchRepos(
                query = query,
                page = page,
                perPage = params.loadSize
            )

            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.items.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(
        state: PagingState<Int, RepoDto>
    ): Int? = state.anchorPosition
}
