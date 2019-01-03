package com.chjaeggi.boardgametracker.data

data class BoardGameApiInfo(
    val apiId: Int = -1,
    val name: String = "",
    val description: String = "",
    val apiRank: Int = -1,
    val thumbnailUrl: String = "",
    val imageUrl: String = "",
    val minPlayers: Int = -1,
    val maxPlayers: Int = -1,
    val minDuration: Int = -1,
    val maxDuration: Int = -1,
    val isCooperative: Boolean = false
)