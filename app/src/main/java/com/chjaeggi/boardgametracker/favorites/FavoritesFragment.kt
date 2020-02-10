package com.chjaeggi.boardgametracker.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chjaeggi.boardgametracker.R
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.chjaeggi.boardgametracker.databinding.FragmentFavoritesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritesFragment : androidx.fragment.app.Fragment() {

    private val viewModel by viewModel<FavoritesViewModel>()
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
        binding.lifecycleOwner = this

        binding.addGame.setOnClickListener { view ->
            MaterialDialog(requireContext()).show {
                input()
                positiveButton(R.string.search)
            }
        }
        return binding.root
    }
}
