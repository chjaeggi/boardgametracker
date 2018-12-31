package com.chjaeggi.boardgametracker.mobile.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if (url != null) Glide.with(context).load(url).into(this)
}