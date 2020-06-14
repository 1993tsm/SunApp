package com.example.sunapp.utils

import android.content.ContentValues

@Suppress("unused")
class ContentValue {

    @SuppressWarnings("unused")
    fun cvOf( vararg pairs: Pair<String, Any?>) = ContentValues().apply {

        for (pair in pairs) {

            val first = pair.first
            when(val second = pair.second) {
                is Int -> put(first, second)
                is Float -> put(first, second)
            }

        }
    }
}