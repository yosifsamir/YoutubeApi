package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaylistDetails {
    @SerializedName("itemCount")
    @Expose
    var itemCount:Int ? =0

    constructor()
    constructor(itemCount: Int?) {
        this.itemCount = itemCount
    }


}