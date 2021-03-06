package com.chjaeggi.boardgametracker.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.chjaeggi.boardgametracker.util.SingleLiveEvent

class FavoritesViewModel : ViewModel() {

    private val _addGame = SingleLiveEvent<String>()
    val addGame: LiveData<String> = _addGame

    fun addGameClicked(game: String) {
        _addGame.postValue(game)
    }

}
