package com.chjaeggi.boardgametracker.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

data class AppRxSchedulers(
    val data: Scheduler = Schedulers.single(),
    val disk: Scheduler = Schedulers.io(),
    val main: Scheduler = AndroidSchedulers.mainThread()
)