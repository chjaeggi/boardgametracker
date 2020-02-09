package com.chjaeggi.boardgametracker.domain

data class WebBoardGame(
    val apiId: Int,
    val name: String,
    val description: String,
    val apiRank: Int,
    val thumbnailUrl: String,
    val imageUrl: String,
    val minPlayers: Int,
    val maxPlayers: Int,
    val playTime: Int
)