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
import java.lang.Exception

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

    fun getGamesList() =
        viewModelScope.launch {
            _gamesUiState.emit(GamesUiState.Loading)
            val result = remoteDataSource.getGamesList()
            if (result.data != null) {
                _gamesUiState.emit(GamesUiState.Success(gamesList = result.data))
            } else {
                _gamesUiState.emit(GamesUiState.Error(exception = result.exception!!))
            }
        }

}

sealed class GamesUiState {
    object Loading : GamesUiState()
    data class Success(
        val gamesList: Flow<PagingData<Game>>
    ) : GamesUiState()

    data class Error(
        val exception: Exception
    ) : GamesUiState()
}
