package com.chjaeggi.boardgametracker.di

import com.chjaeggi.boardgametracker.about.AboutViewModel
import com.chjaeggi.boardgametracker.details.DetailsViewModel
import com.chjaeggi.boardgametracker.download.DownloadManager
import com.chjaeggi.boardgametracker.home.favorites.FavoritesViewModel
import com.chjaeggi.boardgametracker.home.overview.GamesAdapter
import com.chjaeggi.boardgametracker.home.overview.OverviewViewModel
import com.chjaeggi.boardgametracker.home.statistics.StatisticsViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module(override = true) {

    factory { GamesAdapter() }
    viewModel { OverviewViewModel() }

    viewModel { StatisticsViewModel() }

    viewModel { FavoritesViewModel() }

    viewModel { AboutViewModel() }

    viewModel { DetailsViewModel(get()) }
}

val downloadModule = module(override = true) {
    factory { DownloadManager() }
}