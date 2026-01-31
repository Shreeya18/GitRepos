package com.example.gitrepos.githubRepo.data.remote.api

import com.example.gitrepos.githubRepo.data.remote.dto.RepoSearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): RepoSearchResponseDto
}

