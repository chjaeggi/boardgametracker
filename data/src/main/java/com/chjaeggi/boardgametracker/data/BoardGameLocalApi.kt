package com.chjaeggi.boardgametracker.data

interface BoardGameLocalApi {
    fun saveBoardGames(games: List<BoardGameLocalApiInfo>)
}