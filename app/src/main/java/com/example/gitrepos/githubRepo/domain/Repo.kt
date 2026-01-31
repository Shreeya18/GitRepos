package com.example.gitrepos.githubRepo.domain

data class Repo(
    val id: Long,
    val fullName: String,
    val description: String?,
    val stars: Int,
    val avatarUrl: String
)
