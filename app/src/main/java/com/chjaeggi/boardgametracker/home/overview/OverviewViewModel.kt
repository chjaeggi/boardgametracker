package com.chjaeggi.boardgametracker.home.overview

import androidx.lifecycle.ViewModel

class OverviewViewModel : ViewModel() {

    // TODO download from internet
    var games: ArrayList<ListItemGame> = ArrayList()

    init {
        games.add(
            ListItemGame(
                "https://cf.geekdo-images.com/thumb/img/e7GyV4PaNtwmalU-EQAGecwoBSI=/fit-in/200x150/pic2437871.jpg",
                "Gloomhaven",
                3,
                4,
                5,
                6,
                true
            )
        )
        games.add(
            ListItemGame(
                "https://cf.geekdo-images.com/thumb/img/mEmeJrI3AbGTpWyeFOZnR0s_LcY=/fit-in/200x150/pic361592.jpg",
                "Twilight Struggle",
                31,
                41,
                51,
                61,
                true
            )
        )
    }

}
