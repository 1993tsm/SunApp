package com.example.sunapp.base.holder

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

class NormalCell<VDB: ViewDataBinding>(private val brId: Int, private val layoutId: Int): DataBindingCell<VDB>() {

    private val viewModelId = 0
    private lateinit var viewModel: ViewModel

    override fun getLayoutResId(): Int {
        return layoutId
    }

    override fun bindView(vdb: ViewDataBinding?) {
        if(viewModelId != 0) {
            vdb?.setVariable(viewModelId, viewModel)
        }


    }

    override fun bindData(vdb: ViewDataBinding?, item: Any?, position: Int) {
        vdb?.setVariable(brId, item)
    }
}