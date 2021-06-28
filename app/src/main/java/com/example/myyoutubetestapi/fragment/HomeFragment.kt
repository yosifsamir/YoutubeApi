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
class HomeFragment : Fragment() {

    var recyclerView:RecyclerView ? =null
    var recyclerAdapter:HomeAdapter ? =null
    var context2:Context ?=null
    var listOfVideoYT :MutableList<VideoYT> ?= mutableListOf()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        context2=context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=view.findViewById(R.id.homeRecyclerView)
        initAdapter()
        getJsonData()
        return view
    }

    private fun initAdapter() {
        recyclerView!!.layoutManager=LinearLayoutManager(context2,LinearLayoutManager.VERTICAL,false)

    }


    private fun getJsonData() {
        var retrofit=RetrofitChannelBuilder.getChannelRetroft()
        var model=retrofit.create(ChannelApi::class.java).getVideosChannel("snippet","UCIuaQzcckxSlLBe2upHtiPw",context2!!.resources.getString(R.string.youtube_api))
        model.enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(context2,"${t.message}",Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response==null){
                    Toast.makeText(context2,"There are some errors",Toast.LENGTH_LONG).show()
                    return
                }

                listOfVideoYT!!.clear()
                listOfVideoYT!!.addAll(response.body()!!.items!!.asIterable())
                recyclerAdapter= HomeAdapter(context2,listOfVideoYT)
                recyclerView!!.adapter=recyclerAdapter
            }
        })

//        var retrofit=RetrofitChannelBuilder.getChannelRetroft()
//        var model=retrofit.create(ChannelApi::class.java).getVideosChannel2(context2!!.resources.getString(R.string.youtube_api)
//            ,"UCIuaQzcckxSlLBe2upHtiPw"
//            ,"snippet")
//
//        model.enqueue(object : Callback<Model> {
//            override fun onFailure(call: Call<Model>, t: Throwable) {
//                Toast.makeText(context2,"${t.message}",Toast.LENGTH_LONG).show()
//
//            }
//
//            override fun onResponse(call: Call<Model>, response: Response<Model>) {
//                if (response==null){
//                    Toast.makeText(context2,"There are some errors",Toast.LENGTH_LONG).show()
//                    return
//                }
//                Toast.makeText(context2,response.body()!!.items!!.size,Toast.LENGTH_LONG).show()
//                listOfVideoYT!!.addAll(response.body()!!.items!!.asIterable())
//                recyclerAdapter= HomeAdapter(context2,listOfVideoYT)
//                recyclerView!!.adapter=recyclerAdapter
//            }
//        })


    }

//    override fun onStop() {
//        super.onStop()
//        listOfVideoYT!!.clear()
//    }
}
