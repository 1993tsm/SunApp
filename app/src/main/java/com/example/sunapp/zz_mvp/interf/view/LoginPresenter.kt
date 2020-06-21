package com.example.sunapp.zz_mvp.interf.view

import android.content.Context
import com.example.sunapp.zz_mvp.interf.ILoginModule
import com.example.sunapp.zz_mvp.interf.ILoginPrensenter
import com.example.sunapp.zz_mvp.interf.LoginModule
import com.example.sunapp.zz_mvp.interf.LoginView

class LoginPresenter(var iLoginView: LoginView?): ILoginPrensenter, ILoginModule.OnLoginListener {
    override fun attachView() {
    }

    override fun detachView() {
        iLoginView = null
    }

    private val loginModule = LoginModule()
    override fun loginAction(context: Context, userName: String, password: String) {
        loginModule.login(context, userName, password, this)
    }

    override fun loginSuccess() {

    }

    override fun LoginFaiuler() {
    }
}