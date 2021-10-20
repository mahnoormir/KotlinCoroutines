package com.example.kotlincoroutines.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        val BaseURL = "https://api.github.com/search/"

        fun getRetrofitInstance() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}