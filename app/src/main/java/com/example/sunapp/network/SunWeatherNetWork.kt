package com.example.sunapp.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunWeatherNetWork {

    private val weatherService = ServiceCreator.create(WeatherService::class.java)

//    suspend fun getRealTimeWeather(lng: String, lat: String): Call<RealTimeResponse> {
//        return weatherService.getRealTimeWeather(lng, lat)
//    }


    suspend fun getRealTimeWeather(lng: String, lat: String) = weatherService.getRealTimeWeather(lng, lat).await()

    suspend fun getDailyWeather(lng: String, lat: String) = weatherService.getDailyWeather(lng, lat).await()

    private suspend fun <T> Call<T>.await() : T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("Response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

            })
        }

//        return suspendCoroutine(fun(a:Continuation<T>) {
//            enqueue(object : Callback<T> {
//                override fun onResponse(call: Call<T>, response: Response<T>) {
//                    val body = response.body()
//                    if (body != null) a.resume(body)
//                    else a.resumeWithException(RuntimeException("Response body is null"))
//                }
//
//                override fun onFailure(call: Call<T>, t: Throwable) {
//                    a.resumeWithException(t)
//                }
//            })
//        })
    }
}

