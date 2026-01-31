package com.example.gitrepos.githubRepo.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gitrepos.githubRepo.domain.Repo
import com.example.gitrepos.githubRepo.domain.usecase.SearchReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor(
    private val searchRepos: SearchReposUseCase
) : ViewModel() {

    private val queryFlow = MutableStateFlow("")

    val repos: Flow<PagingData<Repo>> =
        queryFlow
            .filter { it.isNotBlank() }
            .flatMapLatest { query ->
                searchRepos(query)
            }
            .cachedIn(viewModelScope)

    fun onSearch(query: String) {
        queryFlow.value = query
    }
}


