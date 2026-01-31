package com.example.gitrepos.githubRepo.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RepoSearchResponseDto(
    val items: List<RepoDto>
)
