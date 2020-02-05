package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

class LocalBoardGameRepository(private val localApi: BoardGameLocalApi) :
    BoardGameRepoSource {

    private var savedBoardGames: List<BoardGame> = listOf()

    override fun saveBoardGame(games: List<Int>): Completable {
        return localApi.saveBoardGames(games.flatMap {
            listOf(
                BoardGameLocalApiInfo(
                    apiId = it,
                    name = (it+1).toString()
                )
            )
        })
    }

    override fun getBoardGame(id: Int): Single<BoardGame> {
        return Single.fromCallable {
            savedBoardGames.find {
                it.id == id
            }
        }
    }

    override fun getBoardGames(): Single<List<BoardGame>> {
        TODO("Not implemented")
    }
}
