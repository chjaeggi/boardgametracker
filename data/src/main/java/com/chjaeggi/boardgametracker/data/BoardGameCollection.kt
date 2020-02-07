package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

interface BoardGameCollection {
    fun getGames(): Single<List<BoardGame>>
    fun getGame(id: Int) : Single<BoardGame>
    fun saveGame(id: Int): Completable
}