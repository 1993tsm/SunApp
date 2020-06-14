package com.example.sunapp.utils

import android.content.Context
import android.content.SharedPreferences

//指定了 block函数类型参数是属于 Editor 上下文的
fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val edit = edit()
    edit.block()
    edit.apply()
}
//使用
fun a(context: Context) {
    context.getSharedPreferences("data", Context.MODE_PRIVATE).open {
        putInt("age", 18)
    }
}