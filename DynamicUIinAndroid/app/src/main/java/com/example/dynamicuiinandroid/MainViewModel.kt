package com.example.latebindingspike

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dynamicuiinandroid.customviews.model.Response
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    val dashboardLiveData: LiveData<Response> = liveData(Dispatchers.IO) {
        emit(BechtelApi.retrofitService.getLayoutDetails())
    }
}