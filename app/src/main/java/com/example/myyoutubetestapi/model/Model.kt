package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

  class Model {
    @SerializedName("nextPageToken")
    @Expose
     var nextPageTokens:String ? =null
    @SerializedName("items")
    @Expose
     var items:MutableList<VideoYT> ? =null

    constructor()
    constructor(nextPageTokens: String?, items: MutableList<VideoYT>?) {
        this.nextPageTokens = nextPageTokens
        this.items = items
    }

}