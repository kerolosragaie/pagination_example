package com.example.paginationexample.features.games.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paginationexample.DependencyContainer
import com.example.paginationexample.features.games.data.remote.api.GamesApiService
import com.example.paginationexample.features.games.data.remote.model.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GamesViewModel(
    private val apiService: GamesApiService = DependencyContainer.apiService
) : ViewModel() {
    private val _gamesList: MutableStateFlow<List<Game>> by lazy { MutableStateFlow(emptyList()) }
    val gamesList: StateFlow<List<Game>> by lazy { _gamesList }

    init {
        getGamesList()
    }

    private fun getGamesList() {
        viewModelScope.launch {
            _gamesList.value = apiService.getGames().games
        }
    }
}