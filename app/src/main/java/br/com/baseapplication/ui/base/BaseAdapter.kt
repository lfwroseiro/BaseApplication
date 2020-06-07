package br.com.baseapplication.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import br.com.baseapplication.utils.AdapterDiffUtil

/**
 * A base class to create list adapters
 *
 * @param layoutId An item view to be inflated in the RecyclerView
 * @param onBind a function to bind data to item view
 */
open class BaseAdapter<T>(
    @LayoutRes private val layoutId: Int,
    val onBind: (T, ViewDataBinding) -> Unit
) : ListAdapter<T, BaseViewHolder>(AdapterDiffUtil()) {

    private var items: List<T> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
    )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items.getOrNull(position)?.let {
            onBind(it, holder.binding)
            return
        }
    }

    fun setList(list: List<T>) {
        items = list
        super.submitList(list)
    }
}