package com.chjaeggi.boardgametracker.data

interface BoardGameWebApi {
    fun getBoardGames() : List<BoardGameWebApiInfo>
}