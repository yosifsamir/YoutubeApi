package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Playlist {

    @SerializedName("items")
    @Expose
    var items:MutableList<PlaylistItem> ? =null
}