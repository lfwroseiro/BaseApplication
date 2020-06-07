package br.com.baseapplication.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LiveData<T>.observeSmart(owner: LifecycleOwner, observer: (T) -> Unit) {
    observe(owner, androidx.lifecycle.Observer { it?.also { source -> observer(source) } })
}
