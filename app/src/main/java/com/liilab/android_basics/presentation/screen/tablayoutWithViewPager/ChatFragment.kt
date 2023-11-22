package com.liilab.android_basics.presentation.screen.tablayoutWithViewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.liilab.android_basics.R

class ChatFragment : Fragment() {

    private lateinit var image: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cat, container, false)
        image = view.findViewById(R.id.image_chat)



        Glide
            .with(this)
            .load("https://wallpapers.com/images/hd/nasa-blue-aurora-5kmngrdsolkdxrdb.webp")
            .placeholder(R.drawable.ic_chat)
            .error(R.drawable.ic_close)
            .into(image)

        return view


    }


}