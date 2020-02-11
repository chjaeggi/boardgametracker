package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import com.chjaeggi.boardgametracker.domain.BoardGameCollection
import io.reactivex.Completable
import io.reactivex.Single

class MyCollection(
    private val remoteStorage: Storage,
    private val localStorage: Storage
) : BoardGameCollection {

    override fun getTop(amount: Int): Single<List<BoardGame>> {
        return remoteStorage.loadTop(amount)
    }

    override fun getGame(name: String): Single<BoardGame> {
        return remoteStorage.loadBoardGame(name)
    }

    override fun saveGame(id: Int): Completable {
        return localStorage.saveBoardGame(listOf(id))
    }


}