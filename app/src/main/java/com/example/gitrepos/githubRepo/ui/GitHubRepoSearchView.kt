package com.example.gitrepos.githubRepo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.gitrepos.githubRepo.domain.Repo
import com.example.gitrepos.githubRepo.ui.viewModel.RepoViewModel

@Composable
fun GitHubRepoSearchView(
    viewModel: RepoViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val repos = viewModel.repos.collectAsLazyPagingItems()
    var query by remember { mutableStateOf("") }

    Column {

        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                viewModel.onSearch(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Search repositories") },
            singleLine = true
        )

        LazyColumn {

            items(
                count = repos.itemCount
            ) { index ->
                val repo = repos[index]
                repo?.let { RepoItem(it) }
            }

            when (repos.loadState.refresh) {
                is LoadState.Loading -> {
                    item { CenterLoader() }
                }
                is LoadState.Error -> {
                    item { Text("Error loading data") }
                }
                else -> Unit
            }
        }
    }
}






@Composable
fun RepoItem(repo: Repo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        AsyncImage(
            model = repo.avatarUrl,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = repo.fullName,
                style = MaterialTheme.typography.titleMedium
            )

            repo.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2
                )
            }

            if (repo.stars > 0) {
                Text(
                    text = "⭐ ${repo.stars}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


@Composable
fun CenterLoader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


