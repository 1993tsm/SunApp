package com.example.sunapp.zz_mvp.interf.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.ParameterizedType

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

    fun createPp() : IBasePresenter {
        val parameterizedType = this.javaClass.genericSuperclass as ParameterizedType
        val actualTypeArguments = parameterizedType.actualTypeArguments
        val type = actualTypeArguments[0] as Class<*>
        val constructor = type.getConstructor(AppCompatActivity::class.java)
        return constructor.newInstance(this) as IBasePresenter
    }

    abstract fun getLayoutId(): Int


    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    abstract fun recycle()
}