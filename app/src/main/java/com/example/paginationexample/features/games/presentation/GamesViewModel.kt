package com.example.paginationexample.features.games.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginationexample.DependencyContainer
import com.example.paginationexample.features.games.data.remote.data_source.RemoteDataSource
import com.example.paginationexample.features.games.data.remote.model.Game
import com.example.paginationexample.features.games.data.remote.paging_source.GamesPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GamesViewModel(
    private val remoteDataSource: RemoteDataSource = DependencyContainer.remoteDataSource
) : ViewModel() {


    private val _gamesUiState: MutableStateFlow<GamesUiState> by lazy { MutableStateFlow(GamesUiState.Loading) }
    val gamesUiState: StateFlow<GamesUiState> by lazy { _gamesUiState }

    init {
        getGamesList()
    }

    private fun getGamesList() {
        viewModelScope.launch {
            val data = remoteDataSource.getGamesList()
            _gamesUiState.emit(GamesUiState.Success(gamesList = data))
        }
    }
}

sealed class GamesUiState {
    object Loading : GamesUiState()
    data class Success(
        val gamesList: Flow<PagingData<Game>>
    ) : GamesUiState()
}
