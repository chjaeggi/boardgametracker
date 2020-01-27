package com.chjaeggi.boardgametracker.di

import androidx.room.Room
import com.chjaeggi.boardgametracker.about.AboutViewModel
import com.chjaeggi.boardgametracker.data.*
import com.chjaeggi.boardgametracker.details.DetailsViewModel
import com.chjaeggi.boardgametracker.download.BoardGameGeek
import com.chjaeggi.boardgametracker.favorites.FavoritesViewModel
import com.chjaeggi.boardgametracker.charts.GamesAdapter
import com.chjaeggi.boardgametracker.charts.ChartsViewModel
import com.chjaeggi.boardgametracker.statistics.StatisticsViewModel
import com.chjaeggi.boardgametracker.local.BoardGameDatabase
import com.chjaeggi.boardgametracker.local.LocalDbImplementation
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val databaseModule = module(override = true) {
    single {
        Room.databaseBuilder(
            androidApplication(),
            BoardGameDatabase::class.java,
            "boardgametracker.db"
        ).build()
    }

    factory { get<BoardGameDatabase>().boardgameDAO() }
}

val dataModule = module(override = true) {
    single<BoardGameRepoSource>("remote") { RemoteBoardGameRepository(get()) }
    single<BoardGameRepoSource>("local") { LocalBoardGameRepository(get()) }
    single<BoardGameDataSource> { BoardGameRepository(get("local"), get("remote")) }
    factory<BoardGameWebApi> { BoardGameGeek() }
    factory<BoardGameLocalApi> { LocalDbImplementation(get()) }
}

val appModule = module(override = true) {

    single { AppRxSchedulers() }

    factory { GamesAdapter() }
    viewModel { ChartsViewModel(get(), get()) }

    viewModel { StatisticsViewModel() }

    viewModel { FavoritesViewModel() }

    viewModel { AboutViewModel() }

    viewModel { (boardGameId: Int) -> DetailsViewModel(get(), get(), boardGameId) }
}
