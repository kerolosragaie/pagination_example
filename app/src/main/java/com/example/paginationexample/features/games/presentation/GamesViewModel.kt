package com.example.paginationexample.features.games.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.paginationexample.DependencyContainer
import com.example.paginationexample.features.games.data.remote.data_source.RemoteDataSource
import com.example.paginationexample.features.games.data.remote.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GamesViewModel(
    private val remoteDataSource: RemoteDataSource = DependencyContainer.remoteDataSource
) : ViewModel() {


    private val _gamesUiState: MutableStateFlow<GamesUiState> by lazy {
        MutableStateFlow(
            GamesUiState.Loading
        )
    }
    val gamesUiState: StateFlow<GamesUiState> by lazy { _gamesUiState }

    init {
        getGamesList()
    }

    fun getGamesList() {
        onEvent(GamesUiState.Loading)
        remoteDataSource.getGamesList()
            .onSuccess {
                onEvent(GamesUiState.Success(it))
            }.onFailure {
                onEvent(GamesUiState.Error(it))
            }
    }

    private fun onEvent(event: GamesUiState) = viewModelScope.launch {
        _gamesUiState.emit(event)
    }
}

sealed class GamesUiState {
    object Loading : GamesUiState()
    data class Success(
        val gamesList: Flow<PagingData<Game>>
    ) : GamesUiState()

    data class Error(
        val data: Exception
    ) : GamesUiState()
}
