package com.chjaeggi.boardgametracker.home.overview

import androidx.lifecycle.MutableLiveData
import com.chjaeggi.boardgametracker.data.BoardGameDataSource
import com.chjaeggi.boardgametracker.domain.BoardGame
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import com.chjaeggi.boardgametracker.util.RxAwareViewModel
import com.chjaeggi.boardgametracker.util.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class OverviewViewModel(
    private val schedulers: AppRxSchedulers,
    private val data: BoardGameDataSource
) : RxAwareViewModel() {

    private val fetchedGamesLiveData = MutableLiveData<List<BoardGame>>()
    val fetchedGames = fetchedGamesLiveData

    fun fetchBoardGames() {
        disposables += data
            .getBoardGames()
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.main)
            .subscribeBy(
                onSuccess = {
                    fetchedGamesLiveData.postValue(it)
                }
            )
    }

}
