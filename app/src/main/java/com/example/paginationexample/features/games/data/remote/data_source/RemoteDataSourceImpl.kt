package com.example.paginationexample.features.games.data.remote.data_source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paginationexample.core.utils.ResultState
import com.example.paginationexample.features.games.data.remote.model.Game
import com.example.paginationexample.features.games.data.remote.paging_source.GamesPagingSource
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val gamesPagingSource: GamesPagingSource = GamesPagingSource(),
) : RemoteDataSource {
    override suspend fun getGamesList(): ResultState<Flow<PagingData<Game>>> = try {
        val pager = Pager(
            pagingSourceFactory = {
                gamesPagingSource
            },
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 15,
            ),
        ).flow
        ResultState.Success(pager)
    } catch (e: Exception) {
        ResultState.Failure(e)
    }

}