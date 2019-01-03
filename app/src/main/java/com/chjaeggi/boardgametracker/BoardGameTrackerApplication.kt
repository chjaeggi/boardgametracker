package com.chjaeggi.boardgametracker

import android.app.Application
import com.chjaeggi.boardgametracker.di.appModule
import com.chjaeggi.boardgametracker.di.dataModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class BoardGameTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(dataModule, appModule))
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}