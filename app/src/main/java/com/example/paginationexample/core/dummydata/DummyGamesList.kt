package com.example.paginationexample.core.dummydata

import com.example.paginationexample.features.games.data.remote.model.Game
import com.example.paginationexample.features.games.data.remote.model.Team


val dummyGamesList = listOf<Game>(
    Game(
        id = 1,
        date = "2024-01-01",
        homeTeam = Team(
            id = 1,
            abbreviation = "HOU",
            city = "Houston",
            name = "Rockets"
        ),
        homeTeamScore = 110,
        time = "7:00 PM",
        visitorTeam = Team(
            id = 2,
            abbreviation = "LAL",
            city = "Los Angeles",
            name = "Lakers"
        ),
        visitorTeamScore = 105
    ),
    Game(
        id = 2,
        date = "2024-01-02",
        homeTeam = Team(
            id = 3,
            abbreviation = "BOS",
            city = "Boston",
            name = "Celtics"
        ),
        homeTeamScore = 98,
        time = "6:30 PM",
        visitorTeam = Team(
            id = 4,
            abbreviation = "NYK",
            city = "New York",
            name = "Knicks"
        ),
        visitorTeamScore = 102
    ),
    Game(
        id = 3,
        date = "2024-01-03",
        homeTeam = Team(
            id = 5,
            abbreviation = "GSW",
            city = "Golden State",
            name = "Warriors"
        ),
        homeTeamScore = 115,
        time = "8:00 PM",
        visitorTeam = Team(
            id = 6,
            abbreviation = "LAC",
            city = "Los Angeles",
            name = "Clippers"
        ),
        visitorTeamScore = 108
    ),
    Game(
        id = 4,
        date = "2024-01-04",
        homeTeam = Team(
            id = 7,
            abbreviation = "MIA",
            city = "Miami",
            name = "Heat"
        ),
        homeTeamScore = 102,
        time = "7:30 PM",
        visitorTeam = Team(
            id = 8,
            abbreviation = "BKN",
            city = "Brooklyn",
            name = "Nets"
        ),
        visitorTeamScore = 98
    ),
    Game(
        id = 5,
        date = "2024-01-05",
        homeTeam = Team(
            id = 9,
            abbreviation = "PHI",
            city = "Philadelphia",
            name = "76ers"
        ),
        homeTeamScore = 112,
        time = "7:00 PM",
        visitorTeam = Team(
            id = 10,
            abbreviation = "TOR",
            city = "Toronto",
            name = "Raptors"
        ),
        visitorTeamScore = 105
    ),
    Game(
        id = 6,
        date = "2024-01-06",
        homeTeam = Team(
            id = 11,
            abbreviation = "DEN",
            city = "Denver",
            name = "Nuggets"
        ),
        homeTeamScore = 120,
        time = "8:30 PM",
        visitorTeam = Team(
            id = 12,
            abbreviation = "UTA",
            city = "Utah",
            name = "Jazz"
        ),
        visitorTeamScore = 115
    ),
    Game(
        id = 7,
        date = "2024-01-07",
        homeTeam = Team(
            id = 13,
            abbreviation = "DAL",
            city = "Dallas",
            name = "Mavericks"
        ),
        homeTeamScore = 105,
        time = "7:30 PM",
        visitorTeam = Team(
            id = 14,
            abbreviation = "SAS",
            city = "San Antonio",
            name = "Spurs"
        ),
        visitorTeamScore = 98
    ),
    Game(
        id = 8,
        date = "2024-01-08",
        homeTeam = Team(
            id = 15,
            abbreviation = "POR",
            city = "Portland",
            name = "Trail Blazers"
        ),
        homeTeamScore = 115,
        time = "7:00 PM",
        visitorTeam = Team(
            id = 16,
            abbreviation = "OKC",
            city = "Oklahoma City",
            name = "Thunder"
        ),
        visitorTeamScore = 110
    ),
)