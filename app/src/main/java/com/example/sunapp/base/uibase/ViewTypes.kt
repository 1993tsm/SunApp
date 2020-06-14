package com.example.sunapp.base.uibase

import androidx.databinding.ViewDataBinding
import com.example.sunapp.base.holder.DataBindingCell

class ViewTypes(classes: ArrayList<Class<Any>> = ArrayList(), vHolders:ArrayList<DataBindingCell<ViewDataBinding>> = ArrayList()) {

    val classes = classes
    val vHolders = vHolders

    fun save(clazz: Class<Any>, vHolder: DataBindingCell<ViewDataBinding>) {
        classes.add(clazz)
        vHolders.add(vHolder)
    }

    fun getClassIndex(clazz: Class<Any>) = classes.indexOf(clazz)

    fun getItemView(index: Int): DataBindingCell<ViewDataBinding> = vHolders[index]
}