package com.example.myyoutubetestapi.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class VideoYT :Serializable {
    @SerializedName("id")
    @Expose
    open var videoId:VideoId ?=null

    @SerializedName("snippet")
    @Expose
    open var snippet:SnippetYT ?=null

    constructor()
    constructor(videoId: VideoId?, snippet: SnippetYT?) {
        this.videoId = videoId
        this.snippet = snippet
    }




}