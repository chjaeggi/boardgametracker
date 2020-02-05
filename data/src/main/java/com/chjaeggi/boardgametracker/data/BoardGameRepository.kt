package com.chjaeggi.boardgametracker.data

import com.chjaeggi.boardgametracker.domain.BoardGame
import io.reactivex.Completable
import io.reactivex.Single

class BoardGameRepository(
    private val localRepository: BoardGameRepoSource,
    private val remoteRepository: BoardGameRepoSource
) : BoardGameDataSource {

    override fun getBoardGames(): Single<List<BoardGame>> {
        return remoteRepository
            .getBoardGames()
//            .doOnSuccess {
//                localRepository.saveBoardGame(listOf(it[0].id))
//            }
    }

    override fun getBoardGame(id: Int): Single<BoardGame> {
        return remoteRepository.getBoardGame(id)
    }

    override fun saveBoardGame(id: Int): Completable {
        return localRepository.saveBoardGame(listOf(id))
    }


}