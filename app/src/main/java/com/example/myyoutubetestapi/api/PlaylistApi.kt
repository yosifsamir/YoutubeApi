package com.example.myyoutubetestapi.api

import com.example.myyoutubetestapi.model.Playlist
import com.example.myyoutubetestapi.model.PlaylistItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistApi {

    /*
    https://youtube.googleapis.com/youtube/v3/playlists
    ?part=snippet,contentDetails
    &channelId=UCIDeTJ1PXVcRbFrmyDKQKkg
    &key=AIzaSyAPB_I08bOf3DlyLQdPvth7BU4DRs7lQNo
    */

    @GET("playlists")
    fun getPlayListsFromChannel(@Query("part") part:String
                                ,@Query("channelId") channelId:String
                                ,@Query("key") key:String): Call<Playlist>
}