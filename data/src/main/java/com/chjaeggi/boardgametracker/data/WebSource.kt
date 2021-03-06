package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import com.chjaeggi.boardgametracker.domain.WebBoardGame

interface WebSource {
    fun fetchTop(amount: Int) : List<WebBoardGame>
    fun fetchGameByName(name: String): BoardGame?
}