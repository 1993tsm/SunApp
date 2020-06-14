package com.example.sunapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SunApplication: Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "cMMKZ3xTOWr3l5HF"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        Log.e("classLoader",AppCompatActivity::class.java.classLoader.toString())
    }
}