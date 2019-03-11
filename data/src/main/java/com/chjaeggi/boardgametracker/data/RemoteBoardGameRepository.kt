package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Single

class RemoteBoardGameRepository(private val webApi: BoardGameWebApi) : BoardGameRepoSource {

    private var savedBoardGames: List<BoardGame> = listOf()

    override fun saveBoardGames(games: List<BoardGame>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBoardGame(id: Int): Single<BoardGame> {
        return Single.fromCallable {
            savedBoardGames.find {
                it.id == id
            }
        }
    }

    override fun getBoardGames(): Single<List<BoardGame>> {
        return Single.fromCallable {
            webApi.getBoardGames()
                .flatMap {
                    listOf(
                        BoardGame(
                            it.apiId,
                            it.name,
                            it.description,
                            it.apiRank,
                            it.thumbnailUrl,
                            it.imageUrl,
                            it.minPlayers,
                            it.maxPlayers,
                            it.playTime,
                            isUserFavorite = false
                        )
                    )
                }
                .sortedBy {
                    it.rank
                }
                .also {
                    savedBoardGames = it
                }
        }
    }
}
