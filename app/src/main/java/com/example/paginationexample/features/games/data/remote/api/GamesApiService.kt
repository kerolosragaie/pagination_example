package com.example.paginationexample.features.games.data.remote.api

import com.example.paginationexample.BuildConfig
import com.example.paginationexample.features.games.data.remote.model.Data
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GamesApiService {
    /**
     * \ ?page=0&per_page=25
     * so used query
     */
    @GET("/games")
    suspend fun getGames(
        @Header("X-RapidAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Header("X-RapidAPI-Host") host: String = BuildConfig.HOST_KEY,
        @Query("page") pageNumber: Int,
        @Query("per_page") perPage: Int = 10,
    ): Data

}