package com.chjaeggi.boardgametracker.details

import android.text.Html
import androidx.databinding.ObservableField
import com.chjaeggi.boardgametracker.data.BoardGameDataSource
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import com.chjaeggi.boardgametracker.util.RxAwareViewModel
import com.chjaeggi.boardgametracker.util.plusAssign
import io.reactivex.rxkotlin.subscribeBy


class DetailsViewModel(
    private val schedulers: AppRxSchedulers,
    private val data: BoardGameDataSource,
    private var boardGameId: Int
) : RxAwareViewModel() {

    val description = ObservableField<String>("")
    val imageUrl = ObservableField<String>("")

    fun fetchCurrentBoardGame() {
        disposables += data
            .getBoardGame(boardGameId)
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.main)
            .subscribeBy(
                onSuccess = {
                    description.set(Html.fromHtml(it.description, Html.FROM_HTML_MODE_LEGACY).toString())
                    imageUrl.set(it.imageUrl)
                }
            )

    }

}