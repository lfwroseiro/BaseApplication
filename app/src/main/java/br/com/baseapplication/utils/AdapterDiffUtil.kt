package br.com.baseapplication.utils

import androidx.recyclerview.widget.DiffUtil

class AdapterDiffUtil<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(
        oldItem: T,
        newItem: T
    ) = compare(oldItem, newItem)

    override fun areContentsTheSame(
        oldItem: T,
        newItem: T
    ) = compare(oldItem, newItem)

    private fun compare(oldItem: T, newItem: T) = oldItem == newItem
}
