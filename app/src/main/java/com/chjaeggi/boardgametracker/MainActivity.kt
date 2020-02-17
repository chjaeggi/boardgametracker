package com.chjaeggi.boardgametracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chjaeggi.boardgametracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.main_nav_fragment)
        val appBarConfig = AppBarConfiguration(
            navController.graph,
            binding.drawerLayout
        )

        binding.navigationView.setupWithNavController(navController)
        binding.toolbar.setupWithNavController(navController, appBarConfig)

        binding.lifecycleOwner = this
    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.main_nav_fragment),
            binding.drawerLayout
        )
    }

}
