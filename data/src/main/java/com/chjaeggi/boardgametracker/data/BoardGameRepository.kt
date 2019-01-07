package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Single
import timber.log.Timber

class BoardGameRepository(private val webApi: BoardGameApi) : BoardGameDataSource {

    private var savedBoardGames: List<BoardGame> = listOf()

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
