package com.example.sunapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(){

    lateinit var binding: T
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,layoutId)

        binding.lifecycleOwner = this
    }
}