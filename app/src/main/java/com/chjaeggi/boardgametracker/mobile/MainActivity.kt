package com.chjaeggi.boardgametracker.mobile

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ActivityMainBinding
import timber.log.Timber

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

//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            Timber.d("XXX: $destination")
//        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.main_nav_fragment),
            binding.drawerLayout
        )
    }

//    override fun onSupportNavigateUp()
//            = findNavController(R.id.main_nav_fragment).navigateUp()

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                return NavigationUI.navigateUp(
//                    Navigation.findNavController(
//                        this,
//                        R.id.main_nav_fragment
//                    ), binding.drawerLayout
//                )
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

}
