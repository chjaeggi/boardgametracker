package com.chjaeggi.boardgametracker.details

import android.text.Html
import androidx.databinding.ObservableField
import com.chjaeggi.boardgametracker.data.BoardGameDataSource
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import com.chjaeggi.boardgametracker.util.RxAwareViewModel
import com.chjaeggi.boardgametracker.util.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber


class DetailsViewModel(
    private val schedulers: AppRxSchedulers,
    private val data: BoardGameDataSource,
    private var boardGameId: Int
) : RxAwareViewModel() {

    val description = ObservableField<String>("")
    val imageUrl = ObservableField<String>("")
    val name = ObservableField<String>("")

    fun fetchCurrentBoardGame() {
        disposables += data
            .getBoardGame(boardGameId)
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.main)
            .subscribeBy(
                onError = {
                    Timber.d("$it")
                },
                onSuccess = {
                    description.set(
                        Html.fromHtml(
                            it.description.replace("&#10;", "<br>", false),
                            Html.FROM_HTML_MODE_LEGACY
                        ).toString()
                    )
                    imageUrl.set(it.imageUrl)
                    name.set(it.name)
                }
            )

    }

    fun save() {
        disposables += data
            .saveBoardGame(boardGameId)
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.main)
            .subscribeBy(
                onComplete = {
                    Timber.d("XXX Saved")
                }
            )
    }

}