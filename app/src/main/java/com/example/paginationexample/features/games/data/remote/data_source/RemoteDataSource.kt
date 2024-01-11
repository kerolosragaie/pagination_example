package com.example.paginationexample.features.games.data.remote.data_source

import androidx.paging.PagingData
import com.example.paginationexample.core.utils.ApiResultState
import com.example.paginationexample.features.games.data.remote.model.Game
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
   fun getGamesList(): ApiResultState<Flow<PagingData<Game>>>
}