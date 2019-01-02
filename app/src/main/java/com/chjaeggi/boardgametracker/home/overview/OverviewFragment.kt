package com.chjaeggi.boardgametracker.home.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentOverviewBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class OverviewFragment : Fragment() {

    private val viewModel by viewModel<OverviewViewModel>()
    private val gamesAdapter: GamesAdapter by inject()
    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)
        binding.allGames.adapter = gamesAdapter
        gamesAdapter.replaceData(viewModel.games)

        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
    }
}
