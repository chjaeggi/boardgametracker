package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

class RemoteStorage(private val webSource: WebSource) : Storage {

    private var savedBoardGames: List<BoardGame> = listOf()

    override fun saveBoardGame(games: List<Int>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBoardGame(name: String): Single<BoardGame> {
        return Single.fromCallable {
            webSource.fetchGameByName(name)
        }
    }

    override fun loadTop(amount: Int): Single<List<BoardGame>> {
        return Single.fromCallable {
            webSource.fetchTop(amount)
                .sortedBy { it.apiRank }
                .flatMap {
                    listOf(
                        BoardGame(
                            it.apiId,
                            it.name,
                            it.description,
                            it.thumbnailUrl,
                            it.imageUrl,
                            it.minPlayers,
                            it.maxPlayers,
                            it.playTime,
                            isUserFavorite = false
                        )
                    )
                }
                .also {
                    savedBoardGames = it
                }
        }
    }
}
