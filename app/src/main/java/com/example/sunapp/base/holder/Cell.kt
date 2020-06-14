package com.example.sunapp.base.holder

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

class Cell<VDB: ViewDataBinding>(cellBuilder: CellBuilder<VDB>) {

    val  presenterModelClass: Class<Any> = cellBuilder.presenterModelClass
    val presenterModelBrId = cellBuilder.presenterModelBrId

    class CellBuilder<VDB: ViewDataBinding>{

        lateinit var presenterModelClass: Class<Any>
        var presenterModelBrId: Int = 0
        var layoutIdRes: Int = 0

        fun presenterModel(presenterModelClass: Class<Any>, presenterModelBrId: Int): CellBuilder<VDB> {
            this.presenterModelClass = presenterModelClass
            this.presenterModelBrId = presenterModelBrId

            return this
        }

        fun layoutId(@LayoutRes layoutResId: Int): CellBuilder<VDB> {
            this.layoutIdRes = layoutResId
            return this
        }

        fun build(): Cell<VDB> {
            return Cell(this)
        }
    }
}