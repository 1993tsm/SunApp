package com.example.sunapp.zz_mvp.interf.view

import android.os.Bundle
import com.example.sunapp.R
import com.example.sunapp.zz_mvp.interf.LoginView
import com.example.sunapp.zz_mvp.interf.view.base.BaseActivity

class LoginActivity: BaseActivity<LoginPresenter>(), LoginView {
    override fun initData() {

    }

    override fun initView() {

    }

    override fun recycle() {
        presenter.detachView()
    }

    override fun createP(): LoginPresenter {
        return LoginPresenter(this@LoginActivity)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}