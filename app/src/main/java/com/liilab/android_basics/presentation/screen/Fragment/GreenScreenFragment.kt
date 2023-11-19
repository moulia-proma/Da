package com.liilab.android_basics.presentation.screen.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.liilab.android_basics.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GreenScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GreenScreenFragment() : Fragment() {

    private lateinit var textTitle: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_green_screen, container, false)
        textTitle = view.findViewById(R.id.text_fragment)

        return view
    }


}