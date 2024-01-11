package com.example.paginationexample.features.games.data.remote.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    var games: ArrayList<Game>?= null,
)

data class Game(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("home_team")
    var homeTeam: Team? = null,
    @SerializedName("home_team_score")
    var homeTeamScore: Int? = null,
    @SerializedName("time")
    var time: String? = null,
    @SerializedName("visitor_team")
    var visitorTeam: Team? = null,
    @SerializedName("visitor_team_score")
    var visitorTeamScore: Int? = null
)


data class Team(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("abbreviation")
    var abbreviation: String? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("name")
    var name: String? = null
)