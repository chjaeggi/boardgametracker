package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Single

class BoardGameRepository : BoardGameDataSource {

    override fun getBoardGames(): Single<List<BoardGame>> =
        Single.fromCallable {
            listOf(
                BoardGame(
                    0,
                    "Gloomhaven",
                    "desc",
                    0,
                    "https://cf.geekdo-images.com/thumb/img/e7GyV4PaNtwmalU-EQAGecwoBSI=/fit-in/200x150/pic2437871.jpg",
                    "Gloomhaven",
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
