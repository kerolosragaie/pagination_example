package com.example.paginationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.paginationexample.core.theme.PaginationExampleTheme
import com.example.paginationexample.features.games.presentation.GamesScreen
import com.example.paginationexample.features.games.presentation.GamesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaginationExampleTheme {
                val vm: GamesViewModel = viewModel()
                val games = vm.gamesList.collectAsState().value
                GamesScreen(games)
            }
        }
    }
}
