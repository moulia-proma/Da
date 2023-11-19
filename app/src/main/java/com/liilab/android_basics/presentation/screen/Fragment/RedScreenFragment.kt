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

class RedScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var textTitle: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_red_screen, container, false)
        textTitle = view.findViewById(R.id.frag_title)
        return view
    }


}