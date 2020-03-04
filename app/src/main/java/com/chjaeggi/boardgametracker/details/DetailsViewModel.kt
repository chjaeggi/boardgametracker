package com.chjaeggi.boardgametracker.details

import android.text.Html
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.chjaeggi.boardgametracker.domain.BoardGameCollection
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import com.chjaeggi.boardgametracker.util.RxAwareViewModel
import com.chjaeggi.boardgametracker.util.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber


class DetailsViewModel(
    private val schedulers: AppRxSchedulers,
    private val collection: BoardGameCollection
) : RxAwareViewModel() {

    val description = ObservableField<String>("")
    val imageUrl = ObservableField<String>("")
    val name = ObservableField<String>("")

    val isLoading = ObservableBoolean(true)

    fun fetchBoardGame(game: String) {
        isLoading.set(true)
        disposables += collection
            .getGame(game)
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.main)
            .subscribeBy(
                onError = {
                    Timber.d("$it")
                    isLoading.set(false)
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
                    isLoading.set(false)
                }
            )

    }

    fun save() {
//        disposables += collection
//            .saveGame(boardGameId)
//            .subscribeOn(schedulers.io)
//            .observeOn(schedulers.main)
//            .subscribeBy(
//                onComplete = {
//                    Timber.d("XXX Saved")
//                }
//            )
    }

}