package com.example.gitrepos.githubRepo.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class RepoDto(
    val id: Long,

    @SerialName("full_name")
    val fullName: String,

    val description: String? = null,

    @SerialName("stargazers_count")
    val stars: Int,

    val owner: OwnerDto
)

@Serializable
data class OwnerDto(
    @SerialName("avatar_url")
    val avatarUrl: String
)
