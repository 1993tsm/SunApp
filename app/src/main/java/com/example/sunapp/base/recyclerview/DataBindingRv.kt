package com.example.sunapp.base.recyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunapp.base.adapter.CommonAdapter
import com.example.sunapp.base.holder.Cell
import com.example.sunapp.base.holder.NormalCell

class DataBindingRv
//@JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int)
    :
    RecyclerView
//        (context, attributeSet, defStyle)
{


    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private lateinit var builder: CommonAdapter.Builder
    private lateinit var commonAdapter: CommonAdapter



    fun <VDB: ViewDataBinding> bind(cell: Cell<VDB>) {
        builder = CommonAdapter.Builder(this)
        builder.bind(cell.presenterModelClass, NormalCell<VDB>(cell.presenterModelBrId, 0))
        commonAdapter = builder.build()
        layoutManager = LinearLayoutManager(context)
        adapter = commonAdapter
    }

}