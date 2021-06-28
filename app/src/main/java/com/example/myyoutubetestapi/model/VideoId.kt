package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VideoId :Serializable {
    @SerializedName("videoId")
    @Expose
    var videoId:String ? =null

    constructor()
    constructor(videoId: String?) {
        this.videoId = videoId
    }

}