package com.example.sunapp.network

import com.example.sunapp.SunApplication
import com.example.sunapp.model.DailyResponse
import com.example.sunapp.model.RealTimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {


    //https://api.caiyunapp.com/
    // v2.5/TAkhjf8d1nlSlspN/121.6544,25.1552/realtime.json

    @GET("v2.5/${SunApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealTimeWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<RealTimeResponse>



    //https://api.caiyunapp.com/
    // v2.5/TAkhjf8d1nlSlspN/121.6544,25.1552/daily.json
    @GET("v2.5/${SunApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String) :
            Call<DailyResponse>

}