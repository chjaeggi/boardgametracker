package com.chjaeggi.boardgametracker.details

import androidx.lifecycle.ViewModel
import com.chjaeggi.boardgametracker.download.DownloadManager
import timber.log.Timber

class DetailsViewModel(downloadManager: DownloadManager) : ViewModel() {

    init {
        Timber.d(downloadManager.getDoc())
    }
}