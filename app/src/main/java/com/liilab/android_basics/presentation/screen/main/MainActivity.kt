package com.liilab.android_basics
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.liilab.android_basics.presentation.screen.MVVM.View.CalculatorActivity
import com.liilab.android_basics.presentation.screen.NavigationGraph.NavigationActivity
import com.liilab.android_basics.presentation.screen.Retrofit.RetrofitActivity
import com.liilab.android_basics.presentation.screen.RetrofitTask.RetrofitTaskActivity
import com.liilab.android_basics.presentation.screen.campaign.CampaignActivity
import com.liilab.android_basics.presentation.screen.listview.ListViewActivity
import com.liilab.android_basics.presentation.screen.main.TempActivity
import com.liilab.android_basics.presentation.screen.recyclerview.RecyclerViewActivity


class MainActivity : AppCompatActivity() {
    private lateinit var listView : MaterialButton
    private lateinit var recyclerView : MaterialButton
    private lateinit var retrofit : MaterialButton
    private lateinit var retrofitTask : MaterialButton
    private lateinit var navigationGraph : MaterialButton
    private lateinit var fragment : MaterialButton
    private lateinit var campaginTask : MaterialButton
    private lateinit var uiTask : MaterialButton

    private lateinit var mvvmCalculator : MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_main)
        listView = findViewById(R.id.btn_listview)
        recyclerView = findViewById(R.id.btn_recycler_view)
        retrofit = findViewById(R.id.btn_retrofit)
        navigationGraph = findViewById(R.id.btn_navigation_graph)
        fragment = findViewById(R.id.btn_fragment)
        campaginTask = findViewById(R.id.btn_campagin_task)
        uiTask= findViewById(R.id.btn_ui_task)
        retrofitTask= findViewById(R.id.btn_retrofit_task)
        mvvmCalculator = findViewById(R.id.btn_mvvm)

         listView.setOnClickListener{
             var intent = Intent(this,ListViewActivity::class.java)
             startActivity(intent)
         }
        recyclerView.setOnClickListener{
            var intent = Intent(this,RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        retrofit.setOnClickListener{
            var intent = Intent(this,RetrofitActivity::class.java)
            startActivity(intent)
        }
        navigationGraph.setOnClickListener{
            var intent = Intent(this,NavigationActivity::class.java)
            startActivity(intent)
        }

        fragment.setOnClickListener{
            var intent = Intent(this,com.liilab.android_basics.presentation.screen.Fragment.FragmentActivity::class.java)
            startActivity(intent)
        }
        campaginTask.setOnClickListener{
            var intent = Intent(this,CampaignActivity::class.java)
            startActivity(intent)
        }
        uiTask.setOnClickListener{
            var intent = Intent(this,TempActivity::class.java)
            startActivity(intent)
        }
        retrofitTask.setOnClickListener{
            var intent = Intent(this,RetrofitTaskActivity::class.java)
            startActivity(intent)
        }
        mvvmCalculator.setOnClickListener{
            var intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }


    }

    }
