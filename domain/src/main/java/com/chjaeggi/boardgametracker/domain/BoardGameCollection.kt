package com.chjaeggi.boardgametracker.domain

import io.reactivex.Completable
import io.reactivex.Single

interface BoardGameCollection {
    fun getTop(amount: Int): Single<List<BoardGame>>
    fun getGame(id: Int) : Single<BoardGame>
    fun saveGame(id: Int): Completable
}