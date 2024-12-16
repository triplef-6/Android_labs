package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StartFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        val startButton = view.findViewById<Button>(R.id.startfragment_button_start)
        startButton.setOnClickListener {
            val navController = view.findNavController() // получаем ссылку на контроллер
            // переходим на цель
            navController.navigate(R.id.action_startFragment_to_messageFragment)

            // или без создания переменной
            // view.findNavController().navigate(R.id.action_startFragment_to_messageFragment)
        }

        // Inflate the layout for this fragment
        return view // создадим переменную для удобства
    }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            StartFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}