package com.liilab.android_basics.presentation.screen.tablayoutWithViewPager

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.NavigatrionDrawer.SaleInfoAdapter
import com.liilab.android_basics.presentation.screen.NavigatrionDrawer.SaleInfoItems
import com.liilab.android_basics.presentation.screen.campaign.XCampaign
import com.liilab.android_basics.presentation.screen.recyclerview.CustomAdapter


class UpdateFragment : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var recyclerViewFruit : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.activity_recycler_view, container, false)
        recyclerViewFruit = view .findViewById(R.id.recycler_view_fruits)
        val campaigns = getCampaigns()
        val adapter = context?.let { SaleInfoAdapter(it,campaigns) }
        val layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)

        recyclerViewFruit.layoutManager=layoutManager
        recyclerViewFruit.adapter = adapter
        return view
    }
    private fun getCampaigns() : ArrayList<SaleInfoItems> {
        val campaigns : ArrayList<SaleInfoItems> = arrayListOf()

        campaigns.add(
          SaleInfoItems(
             label = "Buyers",
              url = "https://mir-s3-cdn-cf.behance.net/project_modules/fs/ac3d34121770739.60cc52c36046d.jpg"
            )
        )
        campaigns.add(
            SaleInfoItems(
                label = "Orders",
                url = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/323a0b149570879.62e9f1db2e4ed.jpg"
            )
        )

        campaigns.add(
            SaleInfoItems(
                label = "Enquiry Received",
                url = "https://mir-s3-cdn-cf.behance.net/project_modules/fs/02d803167862093.64302368795a8.jpg"
            )
        )

        campaigns.add(
            SaleInfoItems(
                label = "Payments",
                url = "https://mir-s3-cdn-cf.behance.net/project_modules/fs/172df4100707723.5f0ec7d42be52.jpg"
            )
        )
        campaigns.add(
            SaleInfoItems(
                label = "Leads",
                url = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/608141179420333.64f943655e8e6.jpg"
            )
        )
        campaigns.add(
            SaleInfoItems(
                label = "Returns",
                url = "https://mir-s3-cdn-cf.behance.net/project_modules/fs/daf74596847829.5eb7e97fd51d0.jpg"
            )
        )

        return campaigns
    }


}