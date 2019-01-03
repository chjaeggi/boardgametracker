package com.chjaeggi.boardgametracker.domain

/**
 * Immutable model class for a BoardGame
 */
data class BoardGame(
    val id: Int,
    val name: String,
    val description: String,
    val rank: Int,
    val thumbnailUrl: String,
    val imageUrl: String,
    val minPlayers: Int,
    val maxPlayers: Int,
    val minDuration: Int,
    val maxDuration: Int,
    val isCooperative: Boolean,
    val isUserFavorite: Boolean
)