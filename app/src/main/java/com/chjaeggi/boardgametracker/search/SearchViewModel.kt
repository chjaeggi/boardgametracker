package com.chjaeggi.boardgametracker.search

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val searchText = ObservableField<String>("")

}
