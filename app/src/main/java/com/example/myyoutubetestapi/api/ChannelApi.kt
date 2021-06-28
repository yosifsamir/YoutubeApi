package com.example.myyoutubetestapi.api

import com.example.myyoutubetestapi.model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChannelApi {
    /*
    curl \
  'https://youtube.googleapis.com/youtube/v3/search
    ?part=snippet
    &channelId=UCIuaQzcckxSlLBe2upHtiPw
    &key=[YOUR_API_KEY]' \
     */

    @GET("search")
    fun getVideosChannel(@Query("part") part:String
                         ,@Query("channelId") channelId:String
                         ,@Query("key") key:String):Call<Model>

    @GET("search")
    fun getVideosChannel2(@Query("key") part:String
                         ,@Query("channelId") channelId:String
                         ,@Query("part") key:String):Call<Model>

    @GET("search")
    fun getVideosQuery(@Query("part") part:String
                         ,@Query("q") query:String
                         ,@Query("maxResults") maxResults:Int
                         ,@Query("key") key:String):Call<Model>

}