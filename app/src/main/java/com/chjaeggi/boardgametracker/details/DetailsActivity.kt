package com.chjaeggi.boardgametracker.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ActivityDetailsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private val viewModel by viewModel<DetailsViewModel>()
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.setLifecycleOwner(this)
    }
}
