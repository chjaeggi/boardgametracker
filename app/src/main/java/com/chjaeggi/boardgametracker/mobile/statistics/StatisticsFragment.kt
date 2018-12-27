package com.chjaeggi.boardgametracker.mobile.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chjaeggi.boardgametracker.R
import org.koin.android.viewmodel.ext.android.viewModel

class StatisticsFragment : androidx.fragment.app.Fragment() {

    private val viewModel by viewModel<StatisticsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
    }
}
