package com.chjaeggi.boardgametracker.mobile.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chjaeggi.boardgametracker.R
import org.koin.android.viewmodel.ext.android.viewModel

class OverviewFragment : androidx.fragment.app.Fragment() {

    private val viewModel by viewModel<OverviewViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
    }
}
