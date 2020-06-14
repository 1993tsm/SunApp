package com.example.sunapp.base.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sunapp.base.holder.DataBindingCell
import com.example.sunapp.base.holder.DataBindingViewHolder
import com.example.sunapp.base.uibase.ViewTypes
import java.util.*
import java.lang.Class as Class

class CommonAdapter(builder: Builder) : PagedListAdapter<Any, RecyclerView.ViewHolder>(diffCallback) {

    private val viewTypes = builder.viewTypes
    private val recyclerView = builder.recyclerView
    private lateinit var layoutInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        val dataBindingCell = viewTypes.getItemView(viewType)
        return dataBindingCell.onCreateViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        val dataBindingCell = viewTypes.getItemView(getItemViewType(position))
        dataBindingCell.onBindViewHolder(holder as DataBindingViewHolder, getItem(position),position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, position, Collections.emptyList())
    }

    override fun getItem(position: Int): Any? {
        return super.getItem(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                return oldItem.javaClass.name == newItem.javaClass.name
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                return oldItem == newItem
            }
        }
    }

    class Builder(recyclerView: RecyclerView) {

        val viewTypes: ViewTypes = ViewTypes()
        val recyclerView = recyclerView

        fun bind(clazz: Class<Any>, dataBindingCell: DataBindingCell<ViewDataBinding>): Builder {
            viewTypes.save(clazz, dataBindingCell)
            return this
        }

        fun build(): CommonAdapter {
            return CommonAdapter(this)
        }
    }


}