package com.chjaeggi.boardgametracker.charts

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.chjaeggi.boardgametracker.domain.BoardGameCollection
import com.chjaeggi.boardgametracker.domain.BoardGame
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import com.chjaeggi.boardgametracker.util.RxAwareViewModel
import com.chjaeggi.boardgametracker.util.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class ChartsViewModel(
    private val schedulers: AppRxSchedulers,
    private val collection: BoardGameCollection
) : RxAwareViewModel() {

    private val fetchedGamesLiveData = MutableLiveData<List<BoardGame>>()
    val fetchedGames = fetchedGamesLiveData

    val isLoading = ObservableBoolean(true)

    fun fetchBoardGames() {
        isLoading.set(true)
        disposables += collection
            .getGames()
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.main)
            .subscribeBy(
                onSuccess = {
                    isLoading.set(false)
                    fetchedGamesLiveData.postValue(it)
                }
            )
    }

}
