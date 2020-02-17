package com.chjaeggi.boardgametracker.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.FragmentUsersBinding
import org.koin.android.viewmodel.ext.android.viewModel

class UsersFragment : androidx.fragment.app.Fragment() {

    private val viewModel by viewModel<UsersViewModel>()
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_users, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}
