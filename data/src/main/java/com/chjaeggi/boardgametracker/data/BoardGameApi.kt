package com.chjaeggi.boardgametracker.data

interface BoardGameApi {
    fun getBoardGames() : List<BoardGameApiInfo>
}