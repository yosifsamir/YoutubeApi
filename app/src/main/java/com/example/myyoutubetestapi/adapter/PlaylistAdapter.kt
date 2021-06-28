package com.example.myyoutubetestapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutubetestapi.R
import com.example.myyoutubetestapi.model.PlaylistItem
import com.squareup.picasso.Picasso

class PlaylistAdapter :RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>{


    var context2:Context ? =null
    var listOfPlaylists:MutableList<PlaylistItem> ? =null

    constructor(context2: Context?, listOfPlaylists: MutableList<PlaylistItem>?) {
        this.context2 = context2
        this.listOfPlaylists = listOfPlaylists
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        var view= LayoutInflater.from(this.context2).inflate(R.layout.row_play_list_layout,parent,false)
        return PlaylistViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfPlaylists!!.size
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        var playlist= this!!.listOfPlaylists!![position]
        holder.titleTextView.text=playlist.snippetYT!!.title
        holder.descriptionTextView.text=playlist.snippetYT!!.description
        holder.totalItemPlaylis.text=playlist.playlistDetails!!.itemCount.toString()
        Picasso.get().load(playlist.snippetYT!!.thumbnails!!.mediumThumbnail!!.url).into(holder.imageViewPlaylist);
    }


    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewPlaylist=itemView.findViewById<ImageView>(R.id.playlist_imageview)
        var titleTextView=itemView.findViewById<TextView>(R.id.playlist_title)
        var descriptionTextView=itemView.findViewById<TextView>(R.id.playlist_description)
        var totalItemPlaylis:TextView=itemView.findViewById(R.id.video_count_play_list)
    }
}