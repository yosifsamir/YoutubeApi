package com.example.myyoutubetestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaylistItem {
    @SerializedName("id")
    @Expose
    var id:String ?=null
    @SerializedName("snippet")
    @Expose
    var snippetYT:SnippetYT ?=null
    @SerializedName("contentDetails")
    @Expose
    var playlistDetails:PlaylistDetails ?=null

    constructor()
    constructor(id: String?, snippetYT: SnippetYT?, playlistDetails: PlaylistDetails?) {
        this.id = id
        this.snippetYT = snippetYT
        this.playlistDetails = playlistDetails
    }

}