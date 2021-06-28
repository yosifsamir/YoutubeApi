package com.example.myyoutubetestapi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutubetestapi.Main2Activity
import com.example.myyoutubetestapi.R
import com.example.myyoutubetestapi.model.VideoYT
import com.squareup.picasso.Picasso

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    var context2: Context? =null
    var listOfVideoYt:MutableList<VideoYT> ? =null

    constructor(cotext2: Context?, listOfVideoYt: MutableList<VideoYT>?) : super() {
        this.context2 = cotext2
        this.listOfVideoYt = listOfVideoYt
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var view=LayoutInflater.from(this.context2).inflate(R.layout.row_home_layout,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfVideoYt!!.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        var videoYT= this!!.listOfVideoYt!![position]
        holder.titleTextView.text=videoYT.snippet!!.title
        holder.descriptionTextView.text=videoYT.snippet!!.description
        Picasso.get().load(videoYT.snippet!!.thumbnails!!.mediumThumbnail!!.url).into(holder.thumbnailImageView);
        holder.itemView.setOnClickListener({
            var intent = Intent(context2,Main2Activity::class.java)
            intent.putExtra("Video_details", this!!.listOfVideoYt!![position])
            context2!!.startActivity(intent)
        })
    }


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnailImageView=itemView.findViewById<ImageView>(R.id.imageView_home)
        var titleTextView=itemView.findViewById<TextView>(R.id.titleHome)
        var descriptionTextView=itemView.findViewById<TextView>(R.id.descriptionHome)

    }
}