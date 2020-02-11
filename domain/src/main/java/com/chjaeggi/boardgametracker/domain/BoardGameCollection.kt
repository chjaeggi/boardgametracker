package com.chjaeggi.boardgametracker.domain

import io.reactivex.Completable
import io.reactivex.Single

interface BoardGameCollection {
    fun getTop(amount: Int): Single<List<BoardGame>>
    fun getGame(name: String) : Single<BoardGame>
    fun saveGame(id: Int): Completable
}