package com.chjaeggi.boardgametracker.di

import com.chjaeggi.boardgametracker.about.AboutViewModel
import com.chjaeggi.boardgametracker.data.BoardGameApi
import com.chjaeggi.boardgametracker.data.BoardGameDataSource
import com.chjaeggi.boardgametracker.data.BoardGameRepository
import com.chjaeggi.boardgametracker.details.DetailsViewModel
import com.chjaeggi.boardgametracker.download.BoardGameGeek
import com.chjaeggi.boardgametracker.home.favorites.FavoritesViewModel
import com.chjaeggi.boardgametracker.home.overview.GamesAdapter
import com.chjaeggi.boardgametracker.home.overview.OverviewViewModel
import com.chjaeggi.boardgametracker.home.statistics.StatisticsViewModel
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val downloadModule = module(override = true) {
    factory<BoardGameApi> { BoardGameGeek() }
}

val dataModule = module(override = true) {
    single<BoardGameDataSource> { BoardGameRepository(get()) }
}

val appModule = module(override = true) {

    single { AppRxSchedulers() }

    factory { GamesAdapter() }
    viewModel { OverviewViewModel(get(), get()) }

    viewModel { StatisticsViewModel() }

    viewModel { FavoritesViewModel() }

    viewModel { AboutViewModel() }

    viewModel { (boardGameId : Int) -> DetailsViewModel(get(), get(), boardGameId) }
}
