package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import com.chjaeggi.boardgametracker.domain.LocalBoardGame
import io.reactivex.Completable
import io.reactivex.Single

class LocalStorage(private val localSource: LocalSource) : Storage {

    private var savedBoardGames: List<BoardGame> = listOf()

    override fun saveBoardGame(games: List<Int>): Completable {
        return localSource.storeBoardGames(games.flatMap {
            listOf(
                LocalBoardGame(
                    apiId = it,
                    name = (it + 1).toString()
                )
            )
        })
    }

    override fun loadBoardGame(name: String): Single<BoardGame> {
        return Single.fromCallable {
            savedBoardGames.find {
                it.name == name
            }
        }
    }

    override fun loadTop(amount: Int): Single<List<BoardGame>> {
        TODO("Not implemented")
    }
}
