package com.chjaeggi.boardgametracker.home.charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentChartsBinding
import com.chjaeggi.boardgametracker.util.observeK
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ChartsFragment : Fragment() {

    private val viewModel by viewModel<ChartsViewModel>()
    private val gamesAdapter: GamesAdapter by inject()
    private lateinit var binding: FragmentChartsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_charts, container, false)
        binding.model = viewModel
        binding.allGames.adapter = gamesAdapter

        with(binding.swipeLayout) {
            setOnRefreshListener {
                viewModel.fetchBoardGames()
                isRefreshing = false
            }
        }

        viewModel.fetchBoardGames()

        viewModel.fetchedGames.observeK(this) {
            if (it != null) {
                gamesAdapter.replaceData(it)
            }
        }

        binding.lifecycleOwner = this
        return binding.root
    }
}
