package com.example.proteamfantasy11rj.pradctionapp.Fragment1

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proteamfantasy11rj.pradctionapp.R
import com.example.proteamfantasy11rj.pradctionapp.databinding.FragmentHomeBinding



class home_Fragment : Fragment() {

var _binding:FragmentHomeBinding?=null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container, false)





binding.button.setOnClickListener {
    Toast.makeText(activity, "Click", Toast.LENGTH_SHORT).show()


    val animal = binding.edText.text.toString().trim()

    val result = when (animal) {
        "Hose" -> {
            binding.ImImage.setImageResource(R.drawable.bag)
            "Animal is house"
        }

        "cat" -> {
            binding.ImImage.setImageResource(R.drawable.banana_2)

            "Animal is cat"

        }

        "Dog" -> {
            binding.ImImage.setImageResource(R.drawable.batbol_2)
            "Animal is Dog"
        }

        else -> {
            binding.ImImage.setImageResource(R.drawable.batnahibol)
            "ye Deta nahi he"
        }
    }
    binding.TeText.text = result
}











        // Inflate the layout for this fragment
        return binding.root
    }override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}