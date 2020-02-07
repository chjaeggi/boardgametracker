package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

class MyCollection(
    private val remoteStorage: Storage,
    private val localStorage: Storage
) : BoardGameCollection {

    override fun getGames(): Single<List<BoardGame>> {
        return remoteStorage
            .loadBoardGames()
//            .doOnSuccess {
//                localRepository.saveBoardGame(listOf(it[0].id))
//            }
    }

    override fun getGame(id: Int): Single<BoardGame> {
        return remoteStorage.loadBoardGame(id)
    }

    override fun saveGame(id: Int): Completable {
        return localStorage.saveBoardGame(listOf(id))
    }


}