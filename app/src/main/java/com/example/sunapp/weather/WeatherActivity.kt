package com.example.sunapp.weather

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sunapp.BR
import com.example.sunapp.R
import com.example.sunapp.base.BaseActivity
import com.example.sunapp.base.holder.Cell
import com.example.sunapp.base.test.TestPresenterModel
import com.example.sunapp.databinding.TestItemBinding

class WeatherActivity: BaseActivity<com.example.sunapp.databinding.ActivityWeatherBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_weather

    private val viewModel by lazy {

        ViewModelProviders.of(this).get(WeatherViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding.setVariable(BR.viewModel, viewModel)
        viewModel.weatherLiveData.observe(this, Observer {result ->
            val weather = result.getOrNull()
            Log.d(TAG, weather.toString())
        })
        binding.getWeather.setOnClickListener {
            viewModel.refreshWeather("121.6544", "25.1552")
        }


        binding.recyclerView.bind(Cell.CellBuilder<TestItemBinding>()
            .layoutId(R.layout.test_item)
            .presenterModel((TestPresenterModel::class as Any).javaClass, BR.presenterModel)
            .build())

    }

    companion object {
        private val TAG: String = WeatherActivity::class.java.simpleName
    }
}