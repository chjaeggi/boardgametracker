package com.chjaeggi.boardgametracker.data

interface WebSource {
    fun fetchBoardGames() : List<WebBoardGame>
}