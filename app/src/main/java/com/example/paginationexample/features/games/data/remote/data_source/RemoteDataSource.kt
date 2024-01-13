package com.example.paginationexample.features.games.data.remote.data_source

import androidx.paging.PagingData
import com.example.paginationexample.core.utils.ResultState
import com.example.paginationexample.features.games.data.remote.model.Game
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getGamesList(): ResultState<Flow<PagingData<Game>>>
}