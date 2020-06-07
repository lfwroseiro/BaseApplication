package br.com.baseapplication.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T : Any> LifecycleOwner.bind(data: LiveData<T>, onTriggered: (T) -> Unit) {
    data.observeSmart(this, { onTriggered.invoke(it) })
}