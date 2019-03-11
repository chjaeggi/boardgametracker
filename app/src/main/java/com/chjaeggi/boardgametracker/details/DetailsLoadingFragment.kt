package com.chjaeggi.boardgametracker.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentDetailsLoadingBinding

class DetailsLoadingFragment : Fragment() {

    private lateinit var binding: FragmentDetailsLoadingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details_loading, container, false)

        binding.lifecycleOwner = this
        return binding.root

    }

}
