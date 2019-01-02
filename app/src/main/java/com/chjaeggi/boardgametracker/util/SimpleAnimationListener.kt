package com.chjaeggi.boardgametracker.util

import android.animation.Animator

open class SimpleAnimatorListener : Animator.AnimatorListener {
    override fun onAnimationRepeat(animator: Animator) {}

    override fun onAnimationEnd(animator: Animator) {}

    override fun onAnimationCancel(animator: Animator) {}

    override fun onAnimationStart(animator: Animator) {}
}