package com.chjaeggi.boardgametracker

import android.app.Application
import com.chjaeggi.boardgametracker.mobile.di.appModule
import org.koin.android.ext.android.startKoin

class BoardGameTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}