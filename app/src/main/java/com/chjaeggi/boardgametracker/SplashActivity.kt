package com.chjaeggi.boardgametracker

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.chjaeggi.boardgametracker.databinding.ActivitySplashBinding
import com.chjaeggi.boardgametracker.util.SimpleAnimatorListener

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private var animator = AnimatorSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        animateLogo()
    }

    private fun animateLogo() {
        binding.titleLogo.alpha = 0F
        binding.titleLogo.scaleX = 1.3F
        binding.titleLogo.scaleY = 1.3F
        binding.titleLogo.translationY = 14F

        val alpha = ObjectAnimator.ofFloat(binding.titleLogo, "alpha", 1F)
        val scaleX = ObjectAnimator.ofFloat(binding.titleLogo, "scaleX", 1F)
        val scaleY = ObjectAnimator.ofFloat(binding.titleLogo, "scaleY", 1F)
        val translation = ObjectAnimator.ofFloat(binding.titleLogo, "translationY", 1F)

        animator.apply {
            playTogether(alpha, scaleX, scaleY, translation)
            startDelay = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
            duration = resources.getInteger(android.R.integer.config_longAnimTime).toLong()
            interpolator = DecelerateInterpolator()
            start()

            addListener(object : SimpleAnimatorListener() {
                override fun onAnimationEnd(animator: Animator) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            })
        }
    }


}
