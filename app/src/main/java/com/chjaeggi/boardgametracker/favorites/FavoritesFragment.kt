package com.chjaeggi.boardgametracker.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentFavoritesBinding
import com.chjaeggi.boardgametracker.util.observeK
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

        binding.addGame.setOnClickListener {
            MaterialDialog(requireContext()).show {
                title(R.string.add_bg_title)
                message(R.string.add_bg_text)
                input(hint = "Mage Knight, e.g.")
                positiveButton(R.string.find) {
                    viewModel.addGameClicked(it.getInputField().text.toString())
                }
                negativeButton(R.string.cancel)
            }
        }

        viewModel.addGame.observeK(this) {
            findNavController()
                .navigate(FavoritesFragmentDirections.actionFavoritesFragmentToSearchFragment(it.toString()))
        }
        return binding.root
    }
}
