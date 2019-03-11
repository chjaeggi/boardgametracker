package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Single

class LocalBoardGameRepository(private val localApi: BoardGameLocalApi) :
    BoardGameRepoSource {

    private var savedBoardGames: List<BoardGame> = listOf()

    override fun saveBoardGames(games: List<BoardGame>) {
        localApi.saveBoardGames(games.flatMap {
            listOf(
                BoardGameLocalApiInfo(
                    apiId = it.id,
                    name = it.name
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
