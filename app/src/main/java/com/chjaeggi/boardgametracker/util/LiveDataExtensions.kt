package com.chjaeggi.boardgametracker.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observeK(owner: LifecycleOwner, crossinline observer: (T?) -> Unit) {
    this.observe(owner, Observer { observer(it) })
}

fun <T> MutableLiveData<T>.postDistinct(newValue: T) {
    if (value != newValue) {
        postValue(newValue)
    }
}
