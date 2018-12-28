package com.chjaeggi.boardgametracker.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val navController = Navigation.findNavController(this, R.id.main_nav_fragment)

        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

        navigation_view.setupWithNavController(navController)

        binding.setLifecycleOwner(this)


//        binding.homeNavBar.setOnNavigationItemSelectedListener {
//            if (binding.homeNavBar.selectedItemId == it.itemId) return@setOnNavigationItemSelectedListener true
//            when (it.itemId) {
//                R.id.home_nav_overview -> {
//                    showHomeFragment(OverviewFragment())
//                    true
//                }
//                R.id.home_nav_favorites -> {
//                    showHomeFragment(FavoritesFragment())
//                    true
//                }
//                R.id.home_nav_statistics -> {
//                    showHomeFragment(StatisticsFragment())
//                    true
//                }
//                else -> {
//                    false
//                }
//            }
//        }

//        if (savedInstanceState == null) {
//            showHomeFragment(OverviewFragment())
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.main_nav_fragment),
            drawer_layout
        )
    }

//    private fun showHomeFragment(newFragment: Fragment) {
//        for (i in 0 until supportFragmentManager.backStackEntryCount) {
//            supportFragmentManager.popBackStack()
//        }
//
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.home_placeholder, newFragment)
//            .commit()
//    }

}
