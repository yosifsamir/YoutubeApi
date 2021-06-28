package com.example.myyoutubetestapi.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myyoutubetestapi.R
import com.example.myyoutubetestapi.Util.RetrofitChannelBuilder
import com.example.myyoutubetestapi.adapter.PlaylistAdapter
import com.example.myyoutubetestapi.api.PlaylistApi
import com.example.myyoutubetestapi.model.Playlist
import com.example.myyoutubetestapi.model.PlaylistItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class PlaylistFragment : Fragment() {
    var recyclerView: RecyclerView? =null
    var recyclerAdapter:PlaylistAdapter ? =null
    var context2: Context?=null
    var listOfPlaylist :MutableList<PlaylistItem> ?= mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context2=context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_playlist, container, false)
        recyclerView=view.findViewById(R.id.playlistRecyclerView)
        initAdapter()
        getJsonData()
        return view
    }

    private fun initAdapter() {
        recyclerView!!.layoutManager=
            LinearLayoutManager(context2, LinearLayoutManager.VERTICAL,false)

    }

    private fun getJsonData() {
        var retrofit = RetrofitChannelBuilder.getChannelRetroft()
        var model = retrofit.create(PlaylistApi::class.java).getPlayListsFromChannel(
            "snippet,contentDetails",
            "UCIDeTJ1PXVcRbFrmyDKQKkg",
            context2!!.resources.getString(R.string.youtube_api)
        )
        model.enqueue(object : Callback<Playlist> {
            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Toast.makeText(context2, "${t.message}", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response == null) {
                    Toast.makeText(context2, "There are some errors", Toast.LENGTH_LONG).show()
                    return
                }
//                Toast.makeText(context2,response.body()!!.items!!.size,Toast.LENGTH_LONG).show()
                listOfPlaylist!!.clear()
                listOfPlaylist!!.addAll(response.body()!!.items!!.asIterable())
                recyclerAdapter = PlaylistAdapter(context2, listOfPlaylist)
                recyclerView!!.adapter = recyclerAdapter
            }
        })
    }

}
