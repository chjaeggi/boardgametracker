package com.chjaeggi.boardgametracker.data

import io.reactivex.Completable

interface LocalSource {
    fun storeBoardGames(games: List<LocalBoardGame>): Completable
}