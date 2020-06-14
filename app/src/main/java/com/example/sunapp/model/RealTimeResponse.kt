package com.example.sunapp.model

import com.google.gson.annotations.SerializedName


/**
 * 实时天气 https://api.caiyunapp.com/v2.5/cMMKZ3xTOWr3l5HF/121.6544,25.1552/realtime.json
 */
data class RealTimeResponse(val status: String, val result: Result) {

    data class Result(val realtime: Realtime) {}

    data class Realtime(val skycon:String, val temperature: Float, @SerializedName("air_quality")val airQuality: AirQuality){}
    data class AirQuality(val aqi: Aqi) {}
    data class Aqi(val chn: Float){}
}