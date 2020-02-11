package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

interface Storage {
    fun loadTop(amount: Int): Single<List<BoardGame>>
    fun loadBoardGame(name: String) : Single<BoardGame>
    fun saveBoardGame(games : List<Int>): Completable
}