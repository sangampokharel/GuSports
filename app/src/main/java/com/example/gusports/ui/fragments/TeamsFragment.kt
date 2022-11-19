package com.example.gusports.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.ui.adapters.TeamsAdapters
import com.example.gusports.models.Team

class TeamsFragment : Fragment() {

    lateinit var cricketRv:RecyclerView
    lateinit var thugsRv:RecyclerView
    lateinit var volleyballRv:RecyclerView
    lateinit var chessRv:RecyclerView
    lateinit var runningRv:RecyclerView
    lateinit var carromRv:RecyclerView
    lateinit var batmintonRv:RecyclerView

    private val teamsAdapters by lazy {
        TeamsAdapters()
    }
    val cricketTeams = arrayListOf<Team>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cricketTeams.add(Team("https://i.pinimg.com/originals/28/09/a8/2809a841bb08827603ccac5c6aee8b33.png","Titans"))
        cricketTeams.add(Team("https://i.pinimg.com/originals/28/09/a8/2809a841bb08827603ccac5c6aee8b33.png","Animation"))
        cricketTeams.add(Team("https://i.pinimg.com/originals/28/09/a8/2809a841bb08827603ccac5c6aee8b33.png","Mumbai indians"))
        cricketTeams.add(Team("https://i.pinimg.com/originals/28/09/a8/2809a841bb08827603ccac5c6aee8b33.png","Chennai"))
        cricketTeams.add(Team("https://i.pinimg.com/originals/28/09/a8/2809a841bb08827603ccac5c6aee8b33.png","Gujarat Titans"))
        cricketTeams.add(Team("https://i.pinimg.com/originals/28/09/a8/2809a841bb08827603ccac5c6aee8b33.png","Deccan Chargers"))


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_teams, container, false)


        setCricketAdapter(view)
        setCarromAdapter(view)
        setBatmintionAdapter(view)
        setVolleyBallAdapter(view)
        setChessAdapter(view)
        setThugsOfWarAdapter(view)
        setRunningAdapter(view)

        return view
    }

    fun setCricketAdapter(view:View){
        cricketRv = view.findViewById(R.id.cricket_rv)
        cricketRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        cricketRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    } fun setThugsOfWarAdapter(view:View){
        thugsRv = view.findViewById(R.id.tow_rv)
        thugsRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        thugsRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    } fun setBatmintionAdapter(view:View){
        batmintonRv = view.findViewById(R.id.batminton_rv)
        batmintonRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        batmintonRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    } fun setRunningAdapter(view:View){
        runningRv = view.findViewById(R.id.running_rv)
        runningRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        runningRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    } fun setChessAdapter(view:View){
        chessRv = view.findViewById(R.id.chess_rv)
        chessRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        chessRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    } fun setCarromAdapter(view:View){
        carromRv = view.findViewById(R.id.carromboard_rv)
        carromRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        carromRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    }fun setVolleyBallAdapter(view:View){
        volleyballRv = view.findViewById(R.id.volleyball_rv)
        volleyballRv.adapter = teamsAdapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        volleyballRv.layoutManager = lm
        teamsAdapters.setData(cricketTeams)

    }

}