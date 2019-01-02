package com.chjaeggi.boardgametracker.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentAboutBinding
import org.koin.android.viewmodel.ext.android.viewModel

class AboutFragment : Fragment() {

    private val viewModel by viewModel<AboutViewModel>()
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
    }

}
