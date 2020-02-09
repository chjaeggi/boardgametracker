package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.LocalBoardGame
import io.reactivex.Completable

interface LocalSource {
    fun storeBoardGames(games: List<LocalBoardGame>): Completable
}