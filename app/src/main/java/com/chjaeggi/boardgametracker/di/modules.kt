package com.chjaeggi.boardgametracker.di

import androidx.room.Room
import com.chjaeggi.boardgametracker.about.AboutViewModel
import com.chjaeggi.boardgametracker.charts.ChartsViewModel
import com.chjaeggi.boardgametracker.charts.GamesAdapter
import com.chjaeggi.boardgametracker.data.*
import com.chjaeggi.boardgametracker.details.DetailsViewModel
import com.chjaeggi.boardgametracker.domain.BoardGameCollection
import com.chjaeggi.boardgametracker.download.BoardGameGeek
import com.chjaeggi.boardgametracker.favorites.FavoritesViewModel
import com.chjaeggi.boardgametracker.local.BoardGameDatabase
import com.chjaeggi.boardgametracker.local.RoomDb
import com.chjaeggi.boardgametracker.search.SearchViewModel
import com.chjaeggi.boardgametracker.statistics.StatisticsViewModel
import com.chjaeggi.boardgametracker.users.UsersViewModel
import com.chjaeggi.boardgametracker.util.AppRxSchedulers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val localModule = module(override = true) {
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
    single<Storage>("remote") { RemoteStorage(get()) }
    single<Storage>("local") { LocalStorage(get()) }
    factory<BoardGameCollection> { MyCollection(get("remote"), get("local")) }
    factory<WebSource> { BoardGameGeek() }
    factory<LocalSource> { RoomDb(get()) }
}

val appModule = module(override = true) {

    single { AppRxSchedulers() }
    factory { GamesAdapter() }
    viewModel { ChartsViewModel(get(), get()) }
    viewModel { StatisticsViewModel() }
    viewModel { UsersViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavoritesViewModel() }
    viewModel { AboutViewModel() }
    viewModel { DetailsViewModel(get(), get()) }
}
