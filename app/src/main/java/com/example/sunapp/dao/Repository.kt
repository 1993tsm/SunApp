package com.example.sunapp.dao

import androidx.lifecycle.liveData
import com.example.sunapp.model.Weather
import com.example.sunapp.network.SunWeatherNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

object Repository {

    fun refreshWeather(lng: String, lat: String) = liveData(Dispatchers.IO) {
        val result = try {
            coroutineScope {
                val deferredRealTime = async {
                    SunWeatherNetWork.getRealTimeWeather(lng, lat)
                }

                val deferredDaily = async {
                    SunWeatherNetWork.getDailyWeather(lng, lat)
                }

                val realTimeResponse = deferredRealTime.await()
                val dailyResponse = deferredDaily.await()

                if (realTimeResponse.status == "ok" && dailyResponse.status == "ok") {
                    val weather = Weather(realTimeResponse, dailyResponse)
                    Result.success(weather)
                } else {
                    Result.failure(
                        RuntimeException(
                            "realTime response status is${realTimeResponse.status}" +
                                    "daily reponse status is ${dailyResponse.status}"
                        )
                    )
                }


            }
        } catch (e: Exception) {
            Result.failure<Weather>(e)
        }
        emit(result)
    }

    fun refreshWeather2(lng: String, lat: String) = fire(Dispatchers.IO) {
        coroutineScope {
            val deferredRealTime = async {
                SunWeatherNetWork.getRealTimeWeather(lng, lat)
            }

            val deferredDaily = async {
                SunWeatherNetWork.getDailyWeather(lng, lat)
            }

            val realTimeResponse = deferredRealTime.await()
            val dailyResponse = deferredDaily.await()

            if (realTimeResponse.status == "OK" && dailyResponse.status == "OK") {
                val weather = Weather(realTimeResponse, dailyResponse)
                Result.success(weather)
            } else {
                Result.failure(
                    RuntimeException(
                        "realTime response status is${realTimeResponse.status}" +
                                "daily reponse status is ${dailyResponse.status}"
                    )
                )
            }
        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}