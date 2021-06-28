package com.example.myyoutubetestapi.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myyoutubetestapi.R
import com.example.myyoutubetestapi.Util.RetrofitChannelBuilder
import com.example.myyoutubetestapi.adapter.HomeAdapter
import com.example.myyoutubetestapi.api.ChannelApi
import com.example.myyoutubetestapi.model.Model
import com.example.myyoutubetestapi.model.VideoYT
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    var recyclerView: RecyclerView? =null
    var recyclerAdapter: HomeAdapter? =null
    var context2: Context?=null
    var listOfVideoYT :MutableList<VideoYT> ?= mutableListOf()

    var searchEdt:EditText ? =null
    var searchBtn : Button ? =null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        context2=context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_search, container, false)
        recyclerView=view.findViewById(R.id.searchRecycleView)
        initAdapter()
        searchEdt=view.findViewById(R.id.searchEdt)
        searchBtn=view.findViewById(R.id.searchBtn)
        searchBtn!!.setOnClickListener({
            if (searchEdt!!.text.toString().length>0){
                getJsonData(searchEdt!!.text.toString())
            }
            else
                Toast.makeText(context2,"Enter some text",Toast.LENGTH_LONG).show()
        })


        return view
    }





    private fun initAdapter() {
        recyclerView!!.layoutManager=
            LinearLayoutManager(context2, LinearLayoutManager.VERTICAL,false)

    }


    private fun getJsonData(data:String) {
        var retrofit = RetrofitChannelBuilder.getChannelRetroft()
        var model = retrofit.create(ChannelApi::class.java).getVideosQuery(
            part="snippet", query = data,maxResults = 10,
             key = context2!!.resources.getString(R.string.youtube_api)
        )
        model.enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(context2, "${t.message}", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response == null) {
                    Toast.makeText(context2, "There are some errors", Toast.LENGTH_LONG).show()
                    return
                }

                listOfVideoYT!!.clear()
                listOfVideoYT!!.addAll(response.body()!!.items!!.asIterable())
                recyclerAdapter = HomeAdapter(context2, listOfVideoYT)
                recyclerView!!.adapter = recyclerAdapter
            }
        })

    }
}
