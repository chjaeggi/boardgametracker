package com.chjaeggi.boardgametracker.mobile.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ActivityDetailsBinding
import org.jsoup.Jsoup
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class DetailsActivity : AppCompatActivity() {

    private val viewModel by viewModel<DetailsViewModel>()
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.setLifecycleOwner(this)

        Thread {
            val doc = Jsoup.connect("https://boardgamegeek.com/browse/boardgame").get()
            Timber.d("XXX: ${doc.html()}")
        }.start()
    }
}
