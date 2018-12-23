package com.chjaeggi.boardgametracker.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.chjaeggi.boardgametracker.R

class BaseFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = BaseFragment()
    }

    private lateinit var viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.base_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
