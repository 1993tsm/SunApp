package com.example.sunapp.weather

import androidx.arch.core.util.Function
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.example.sunapp.dao.Repository
import com.example.sunapp.model.Location

class WeatherViewModel: ViewModel() {


    private val locationLiveData = MutableLiveData<Location>()
    val locationLng = ""
    val locationLat = ""
    val place = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) {
        Repository.refreshWeather(it.lng, it.lat)
    }


    //刷新liveData
    fun refreshWeather(lng: String, lat:String) {
        locationLiveData.value = Location(lng, lat)


    }

}