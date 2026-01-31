package com.example.gitrepos.githubRepo.data.mapper

import com.example.gitrepos.githubRepo.data.remote.dto.RepoDto
import com.example.gitrepos.githubRepo.domain.Repo


fun RepoDto.toDomain(): Repo {
    return Repo(
        id = id,
        fullName = fullName,
        description = description,
        stars = stars,
        avatarUrl = owner.avatarUrl
    )
}

