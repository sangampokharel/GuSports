package com.example.gusports.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.models.Players
import com.example.gusports.ui.adapters.PlayersAdapters
import com.example.gusports.utils.Resource
import com.example.gusports.viewmodels.PlayersActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_players.*
@AndroidEntryPoint
class PlayersActivity : AppCompatActivity() {
    private lateinit var playersRv: RecyclerView

    private val playersAdapters by lazy {
        PlayersAdapters()
    }

    private val playersActivityViewModel by viewModels<PlayersActivityViewModel>()
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        players_back_btn.setOnClickListener {
            finish()
        }
        playersRv = findViewById(R.id.players_rv)
        val lm = LinearLayoutManager(this)
        playersRv.layoutManager=lm
        playersRv.adapter = playersAdapters

        if(intent.hasExtra("category") && intent.hasExtra("teamid")){
            val category = intent.getStringExtra("category")
            val teamid = intent.getStringExtra("teamid")

            playersActivityViewModel.getPlayers(category = category!!, teamId = teamid!!)
        }

        playersActivityViewModel.players.observe(this) {
            when(it){
                is Resource.Loading->{
                    players_progress.visibility = View.VISIBLE
                }

                is Resource.Success->{
                    players_progress.visibility = View.INVISIBLE
                    players_rv.visibility = View.VISIBLE
                    Log.d("Players data",it.data.size.toString())
                    playersAdapters.setData(it.data)
                }

                is Resource.Failure->{
                    players_progress.visibility = View.INVISIBLE
                    Toast.makeText(this,it.error,Toast.LENGTH_SHORT).show()
                }
            }


        }



    }


}