package com.example.sunapp.base.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingCell<out VDB : ViewDataBinding?> {

    fun onCreateViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup) : DataBindingViewHolder {
        val view = layoutInflater.inflate(getLayoutResId(), parent, false)
        val vdb = DataBindingUtil.bind<ViewDataBinding>(view)
        bindView(vdb)
        return DataBindingViewHolder(vdb, view)
    }

    fun onBindViewHolder(viewHolder: DataBindingViewHolder, item: Any?, position: Int){
        bindData(viewHolder.vdb, item, position)
    }

    abstract fun getLayoutResId(): Int
    abstract fun bindView(vdb: ViewDataBinding?)
    abstract fun bindData(vdb: ViewDataBinding?, item: Any?, position: Int)
}