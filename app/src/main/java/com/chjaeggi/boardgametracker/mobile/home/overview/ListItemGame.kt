package com.chjaeggi.boardgametracker.mobile.home.overview

data class ListItemGame(
    val thumbnailUrl: String,
    val name: String,
    val minPlayers: Int,
    val maxPlayers: Int,
    val minDuration: Int,
    val maxDuration: Int,
    val isFavorite: Boolean
)