package com.example.kotlincoroutines.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.models.RecyclerList
import com.example.kotlincoroutines.network.RetroInstance
import com.example.kotlincoroutines.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel(){
    lateinit var recyclerListLiveData : MutableLiveData<RecyclerList>
    init {
       recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerlistObserver(): MutableLiveData<RecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch (Dispatchers.IO){
            val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}