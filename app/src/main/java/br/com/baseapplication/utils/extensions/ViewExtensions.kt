package br.com.baseapplication.utils.extensions

import android.view.View

fun View.setIsVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}
