package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Single

class BoardGameRepository(private val webApi: BoardGameApi) : BoardGameDataSource {

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
        }
    }
}
