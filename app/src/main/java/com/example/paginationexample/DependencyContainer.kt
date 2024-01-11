package com.example.paginationexample

import com.example.paginationexample.features.games.data.remote.api.GamesApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DependencyContainer {
    val apiService: GamesApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://free-nba.p.rapidapi.com")
        .build().create(GamesApiService::class.java)
}