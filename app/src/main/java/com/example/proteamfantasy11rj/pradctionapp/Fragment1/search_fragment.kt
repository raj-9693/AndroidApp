package com.example.proteamfantasy11rj.pradctionapp.Fragment1

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proteamfantasy11rj.pradctionapp.R
import com.example.proteamfantasy11rj.pradctionapp.databinding.FragmentSearchFragmentBinding


class search_fragment : Fragment() {

    var _binding:FragmentSearchFragmentBinding?=null
    val binding get() = _binding!!

     var newsArrayList= ArrayList<News>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSearchFragmentBinding.inflate(inflater,container, false)



val myRecyclerViw=binding.recyclerview

val newsImageArrray= arrayOf(
    R.drawable.bag,
    R.drawable.btn_1,
    R.drawable.btn_3,
    R.drawable.btn_3,
    R.drawable.baseline_airport_shuttle_24,
)
        val newsHEading= arrayOf(

            "Hello raj bahi mumbi chale ga kay",
            "Bon na be chale ga kay ",
            "Nahi chale ja fir be bol de na",
            "chal na be ",
            "kay bat he Rj raj",
        )
myRecyclerViw.layoutManager=LinearLayoutManager(activity)

      newsArrayList= arrayListOf<News>()

        for (index in newsImageArrray.indices){
            val news=News(newsHEading[index],newsImageArrray[index])
            newsArrayList.add(news)
        }
        myRecyclerViw.adapter=MyAdapter(newsArrayList, Activity())
        // Inflate the layout for this fragment
        return binding.root
    }


}