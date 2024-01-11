package com.example.paginationexample.features.games.data.remote.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationexample.DependencyContainer
import com.example.paginationexample.features.games.data.remote.api.GamesApiService
import com.example.paginationexample.features.games.data.remote.model.Game

class GamesPagingSource(
    private val apiService: GamesApiService = DependencyContainer.apiService,
) : PagingSource<Int, Game>() {
    override fun getRefreshKey(state: PagingState<Int, Game>): Int? =
        state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return try {
            val pageNumber: Int = params.key ?: 0
            val games = apiService.getGames(
                pageNumber = pageNumber,
            ).games

            if (games != null) {
                LoadResult.Page(
                    data = games,
                    prevKey = if (pageNumber == 0) null else pageNumber,
                    nextKey = pageNumber + 1,
                )
            } else {
                LoadResult.Error(Throwable("No data found!"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}