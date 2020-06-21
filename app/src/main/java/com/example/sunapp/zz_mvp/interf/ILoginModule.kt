package com.example.sunapp.zz_mvp.interf

import android.content.Context

interface ILoginModule {
    fun cancelRequest()
    fun login(context: Context, userName: String, password: String,
              //返回登录结果给P层
                onLoginListener: OnLoginListener
              )


    interface OnLoginListener {
        fun loginSuccess()
        fun LoginFaiuler()
    }
}