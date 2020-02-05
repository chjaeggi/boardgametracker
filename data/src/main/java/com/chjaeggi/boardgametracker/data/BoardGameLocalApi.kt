package com.chjaeggi.boardgametracker.data

import io.reactivex.Completable

interface BoardGameLocalApi {
    fun saveBoardGames(games: List<BoardGameLocalApiInfo>): Completable
}