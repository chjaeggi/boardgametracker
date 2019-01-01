package com.chjaeggi.boardgametracker.mobile.home.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentOverviewBinding
import org.koin.android.viewmodel.ext.android.viewModel

class OverviewFragment : androidx.fragment.app.Fragment() {

    private val viewModel by viewModel<OverviewViewModel>()
    private lateinit var binding: FragmentOverviewBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)

        binding.allGames.adapter = GamesAdapter(viewModel.games)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
    }
}
