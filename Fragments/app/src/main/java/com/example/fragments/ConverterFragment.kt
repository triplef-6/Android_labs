package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ConverterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {val view = inflater.inflate(R.layout.fragment_converter, container, false)

        val message = ConverterFragmentArgs.fromBundle(requireArguments()).message
        var meow = ""
        repeat(message.length){
            meow += "мяу "
        }
        val translatedText = view.findViewById<TextView>(R.id.converterfragment_text)
        translatedText.text = meow

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ConverterFragment()
    }
}