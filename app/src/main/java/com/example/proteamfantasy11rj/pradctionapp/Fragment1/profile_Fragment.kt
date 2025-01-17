package com.example.proteamfantasy11rj.pradctionapp.Fragment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proteamfantasy11rj.pradctionapp.R
import com.example.proteamfantasy11rj.pradctionapp.databinding.FragmentProfileBinding


class profile_Fragment : Fragment() {
    var _binding:FragmentProfileBinding?=null
    val binding get() =_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentProfileBinding.inflate(inflater,container, false)

        binding.sumitButton.setOnClickListener {
            // EditText से टेक्स्ट लेना और ट्रिम करना
            val number = binding.editText.text.toString().trim()

            // String को Int में कन्वर्ट करना
            val number1 = number.toIntOrNull()

            // अगर number1 null है, तो एरर मैसेज दिखाएं
            if (number1 == null) {
                binding.table.text = "कृपया एक वैध संख्या दर्ज करें"
                return@setOnClickListener
            }

            // गुणा का पहाड़ा बनाने के लिए StringBuilder का उपयोग करें
            val tableBuilder = StringBuilder()
            for (i in 1..10) {
                tableBuilder.append("$number1 x $i = ${number1 * i}\n")
            }

            // Table को TextView में सेट करें
            binding.table.text = tableBuilder.toString()
        }




//        binding.sumitButton.setOnClickListener {
//            // EditText से टेक्स्ट लेना और ट्रिम करना
//            val button = binding.editText.text.toString().trim()
//
//            // String को Int में कन्वर्ट करना
//            val number = button.toIntOrNull()
//
//            // अगर नंबर वैध नहीं है, तो यूजर को एरर दिखाएं
//            if (number == null) {
//                binding.table.text = "कृपया एक वैध संख्या दर्ज करें"
//                return@setOnClickListener
//            }
//
//            // गुणा का पहाड़ा बनाने के लिए StringBuilder का उपयोग करें
//            val tableBuilder = StringBuilder()
//            for (i in 1..10) {
//                tableBuilder.append("$number x $i = ${number * i}\n")
//            }
//
//            // Table को TextView में सेट करें
//            binding.table.text = tableBuilder.toString()
//        }


        // Inflate the layout for this fragment
        return binding.root
    }


    }
