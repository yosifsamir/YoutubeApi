package com.example.myyoutubetestapi.Util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitChannelBuilder {
    private constructor()

    companion object{
        val BASE_URL="https://youtube.googleapis.com/youtube/v3/"
        fun getChannelRetroft():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}