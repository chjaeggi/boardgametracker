package com.chjaeggi.boardgametracker.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ActivityDetailsBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailsActivity : AppCompatActivity() {

    companion object {
        private const val GAME_ID = "unique_game_id"

        fun bundleArgs(gameId: Int): Bundle {
            return Bundle().apply {
                this.putInt(GAME_ID, gameId)
            }
        }
    }

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by viewModel {
        parametersOf(intent.getIntExtra(GAME_ID, -1))
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.setLifecycleOwner(this)


        viewModel.fetchCurrentBoardGame()
        Navigation.findNavController(this, R.id.details_nav_fragment)
            .navigate(
                R.id.details_fragment,
                null,
                NavOptions.Builder().setPopUpTo(R.id.details_loading_fragment, true).build()
            )
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
