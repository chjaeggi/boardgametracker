package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

interface Storage {
    fun loadBoardGames(): Single<List<BoardGame>>
    fun loadBoardGame(id: Int) : Single<BoardGame>
    fun saveBoardGame(games : List<Int>): Completable
}