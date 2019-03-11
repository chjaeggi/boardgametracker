package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Single

class BoardGameRepository(
    private val localRepository: BoardGameRepoSource,
    private val remoteRepository: BoardGameRepoSource
) : BoardGameDataSource {

    override fun getBoardGames(): Single<List<BoardGame>> {
        return remoteRepository
            .getBoardGames()
            .doOnSuccess {
                localRepository.saveBoardGames(it)
            }
    }

    override fun getBoardGame(id: Int): Single<BoardGame> {
        return remoteRepository.getBoardGame(id)
    }

}