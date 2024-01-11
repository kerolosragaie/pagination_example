package com.example.paginationexample.features.games.data.remote.api

import com.example.paginationexample.BuildConfig
import com.example.paginationexample.features.games.data.remote.model.Data
import retrofit2.http.GET
import retrofit2.http.Header

interface GamesApiService {
    @GET("/games?page=0&per_page=25")
    suspend fun getGames(
        @Header("X-RapidAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Header("X-RapidAPI-Host") host: String = BuildConfig.HOST_KEY,
    ): Data
}