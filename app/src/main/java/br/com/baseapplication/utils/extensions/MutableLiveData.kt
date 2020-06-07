package br.com.baseapplication.utils.extensions

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Boolean>.trigger() {
    value = true
}
