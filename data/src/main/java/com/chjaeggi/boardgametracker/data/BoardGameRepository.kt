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
                            "desc",
                            it.apiRank,
                            "https://cf.geekdo-images.com/thumb/img/e7GyV4PaNtwmalU-EQAGecwoBSI=/fit-in/200x150/pic2437871.jpg",
                            "no url",
                            0,
                            0,
                            0,
                            0,
                            true,
                            false
                        )
                    )
                }
        }
    }
}
