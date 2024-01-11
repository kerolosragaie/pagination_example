package com.example.paginationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paginationexample.core.theme.PaginationExampleTheme
import com.example.paginationexample.features.games.presentation.GamesScreen
import com.example.paginationexample.features.games.presentation.GamesUiState
import com.example.paginationexample.features.games.presentation.GamesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaginationExampleTheme {
                val vm: GamesViewModel = viewModel()

                when(val gamesUiState = vm.gamesUiState.collectAsState().value){
                    GamesUiState.Loading -> CircularProgressIndicator()
                    is GamesUiState.Success -> {
                        val gamesList = gamesUiState.gamesList.collectAsLazyPagingItems()
                        GamesScreen(games = gamesList)
                    }
                }

            }
        }
    }
}
