package com.chjaeggi.boardgametracker.local

import com.chjaeggi.boardgametracker.data.BoardGameLocalApi
import com.chjaeggi.boardgametracker.data.BoardGameLocalApiInfo

class LocalDbImplementation(private val boardgameDao: BoardGameDAO) : BoardGameLocalApi {

    override fun saveBoardGames(games: List<BoardGameLocalApiInfo>) {
        boardgameDao.saveGames(games.flatMap {
            listOf(BoardGameEntity(id = it.apiId, name = it.name))
        })
    }
}