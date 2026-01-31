package com.example.gitrepos.githubRepo.data

data class GitHubRepositories(
    val id: Int,
    val repositoryName: String,
    val description:String,
    val starCounts: Int,
    val ownerAvatar: String
)
