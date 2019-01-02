package com.chjaeggi.boardgametracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ActivityMainBinding
import android.os.StrictMode



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.main_nav_fragment)

        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        binding.setLifecycleOwner(this)
    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.main_nav_fragment),
            binding.drawerLayout
        )
    }

}
