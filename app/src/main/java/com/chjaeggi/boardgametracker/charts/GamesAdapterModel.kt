package com.chjaeggi.boardgametracker.charts

data class GamesAdapterModel(
    val id: Int,
    val name: String,
    val thumbnailUrl: String,
    val rankString: String,
    val playTimeString: String,
    val playersString: String
)