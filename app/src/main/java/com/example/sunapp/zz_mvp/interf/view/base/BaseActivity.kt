package com.example.sunapp.zz_mvp.interf.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P>: AppCompatActivity() where P: IBasePresenter{
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        presenter = createP()
        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()


    abstract fun createP():P

    abstract fun getLayoutId(): Int


    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    abstract fun recycle()
}