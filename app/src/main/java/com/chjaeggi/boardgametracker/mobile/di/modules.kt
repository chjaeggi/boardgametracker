package com.chjaeggi.boardgametracker.mobile.di

import com.chjaeggi.boardgametracker.mobile.HomeViewModel
import com.chjaeggi.boardgametracker.mobile.about.AboutViewModel
import com.chjaeggi.boardgametracker.mobile.favorites.FavoritesViewModel
import com.chjaeggi.boardgametracker.mobile.overview.OverviewViewModel
import com.chjaeggi.boardgametracker.mobile.statistics.StatisticsViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module(override = true) {

    viewModel { OverviewViewModel() }
    viewModel { StatisticsViewModel() }
    viewModel { FavoritesViewModel() }
    viewModel { AboutViewModel() }
    viewModel { HomeViewModel() }
}