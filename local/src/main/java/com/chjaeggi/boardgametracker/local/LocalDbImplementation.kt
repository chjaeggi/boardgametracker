package com.chjaeggi.boardgametracker.local

import com.chjaeggi.boardgametracker.data.BoardGameLocalApi
import com.chjaeggi.boardgametracker.data.BoardGameLocalApiInfo
import io.reactivex.Completable

class LocalDbImplementation(private val boardgameDao: BoardGameDAO) : BoardGameLocalApi {

    override fun saveBoardGames(games: List<BoardGameLocalApiInfo>): Completable {
        return Completable.fromCallable {
            boardgameDao.saveGames(games.flatMap {
                listOf(BoardGameEntity(id = it.apiId, name = it.name))
            })
        }
    }
}