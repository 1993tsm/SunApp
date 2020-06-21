package com.example.sunapp.zz_mvp.interf

import android.content.Context
import com.example.sunapp.zz_mvp.interf.view.base.IBasePresenter

interface ILoginPrensenter: IBasePresenter {

    fun loginAction(context: Context, userName: String, password: String)
}