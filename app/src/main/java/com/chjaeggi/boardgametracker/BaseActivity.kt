package com.chjaeggi.boardgametracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chjaeggi.boardgametracker.ui.base.BaseFragment

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BaseFragment.newInstance())
                .commitNow()
        }
    }

}
