package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

class RemoteStorage(private val webSource: WebSource) : Storage {

    private var savedBoardGames: List<BoardGame> = listOf()

    override fun saveBoardGame(games: List<Int>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBoardGame(id: Int): Single<BoardGame> {
        return Single.fromCallable {
            savedBoardGames.find {
                it.id == id
            }
        }
    }

    override fun loadBoardGames(): Single<List<BoardGame>> {
        return Single.fromCallable {
            webSource.fetchBoardGames()
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
