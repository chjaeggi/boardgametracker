package com.chjaeggi.boardgametracker.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentDetailsBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.sharedViewModel


class DetailsFragment : Fragment() {

    private val viewModel by sharedViewModel<DetailsViewModel>()
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.model = viewModel
        binding.toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
        binding.moreDetails.setOnClickListener {
            Snackbar.make(it, R.string.not_implemented_yet, Snackbar.LENGTH_SHORT).show()
        }
        binding.lifecycleOwner = this
        return binding.root

    }
}
