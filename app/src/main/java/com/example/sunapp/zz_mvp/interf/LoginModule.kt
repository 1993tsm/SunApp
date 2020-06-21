package com.example.sunapp.zz_mvp.interf

import android.content.Context
import com.example.sunapp.network.ServiceCreator

class LoginModule : ILoginModule {
    override fun cancelRequest() {

    }

    override fun login(
        context: Context,
        userName: String,
        password: String,
        onLoginListener: ILoginModule.OnLoginListener
    ) {


    }
}