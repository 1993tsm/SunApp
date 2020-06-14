package com.example.sunapp.base.holder

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder(v: ViewDataBinding?, view: View): RecyclerView.ViewHolder(view) {
    val vdb = v
}