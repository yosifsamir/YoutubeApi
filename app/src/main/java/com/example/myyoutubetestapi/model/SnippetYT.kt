package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SnippetYT :Serializable{
    @SerializedName("publishedAt")
    @Expose
    var publishAt:String ? = null

    @SerializedName("title")
    @Expose
    var title:String ? =null

    @SerializedName("description")
    @Expose
    var description:String ?=null

    @SerializedName("thumbnails")
    @Expose
    var thumbnails:ThumbnailYT ? =null

//    @SerializedName("channelId")
//    @Expose
//    var channelId: String? = null


    constructor()
    constructor(
        publishAt: String?,
        title: String?,
        description: String?,
        thumbnails: ThumbnailYT?
    ) {
        this.publishAt = publishAt
        this.title = title
        this.description = description
        this.thumbnails = thumbnails
    }


}