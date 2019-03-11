package com.chjaeggi.boardgametracker

import android.app.Application
import com.chjaeggi.boardgametracker.di.*
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class BoardGameTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(databaseModule, dataModule, appModule))
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}