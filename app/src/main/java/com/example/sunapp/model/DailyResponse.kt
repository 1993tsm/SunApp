package com.example.sunapp.model

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class DailyResponse (val status: String, val result:Result){
    data class Result(val daily: Daily) {}
    data class Daily(val temperature: List<Temperature>, val skycon: List<Skycon>,
                     @SerializedName("life_index")val lifeIndex: LifeIndex) {}

    class LifeIndex(val coldRisk: List<LifeDescription>, val carWashing: List<LifeDescription>,
                    val dressing: List<LifeDescription>, val ultraviolet: List<LifeDescription>) {

    }

    class LifeDescription {

    }

    class Skycon(val date: String, val value: String) {

    }

    data class Temperature(val max: Float, val min: Float) {}
}