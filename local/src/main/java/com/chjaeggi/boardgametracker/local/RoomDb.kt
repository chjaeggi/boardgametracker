package com.chjaeggi.boardgametracker.local

import com.chjaeggi.boardgametracker.data.LocalSource
import com.chjaeggi.boardgametracker.data.LocalBoardGame
import io.reactivex.Completable

class RoomDb(private val boardgameDao: BoardGameDAO) : LocalSource {

    override fun storeBoardGames(games: List<LocalBoardGame>): Completable {
        return Completable.fromCallable {
            boardgameDao.saveGames(games.flatMap {
                listOf(BoardGameEntity(id = it.apiId, name = it.name))
            })
        }
    }
}