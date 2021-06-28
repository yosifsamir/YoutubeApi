package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MediumThumnail:Serializable {
    @SerializedName("url")
    @Expose
    var url:String ? =null

    constructor()
    constructor(url: String?) {
        this.url = url
    }

}