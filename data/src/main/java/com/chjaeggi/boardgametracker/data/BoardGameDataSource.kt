package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

interface BoardGameDataSource {
    fun getBoardGames(): Single<List<BoardGame>>
    fun getBoardGame(id: Int) : Single<BoardGame>
    fun saveBoardGame(id: Int): Completable
}