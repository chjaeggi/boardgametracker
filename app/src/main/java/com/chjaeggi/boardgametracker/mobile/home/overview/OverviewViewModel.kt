package com.chjaeggi.boardgametracker.mobile.home.overview

import androidx.lifecycle.ViewModel

class OverviewViewModel : ViewModel() {

    // TODO download from internet
    var games: ArrayList<ListItemGame> = ArrayList()

    init {
        games.add(ListItemGame("1", "2", 3, 4, 5, 6, true))
        games.add(ListItemGame("11", "21", 31, 41, 51, 61, true))
    }

}
