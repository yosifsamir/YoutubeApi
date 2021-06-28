package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ThumbnailYT:Serializable {
    @SerializedName("medium")
    @Expose
    var mediumThumbnail:MediumThumnail ? =null

    constructor()
    constructor(mediumThumbnail: MediumThumnail?) {
        this.mediumThumbnail = mediumThumbnail
    }

}