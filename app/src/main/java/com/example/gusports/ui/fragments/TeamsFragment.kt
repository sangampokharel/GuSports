package com.example.gusports.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.ui.adapters.TeamsAdapters
import com.example.gusports.models.Team
import com.example.gusports.utils.Resource
import com.example.gusports.viewmodels.TeamsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_teams.*
@AndroidEntryPoint
class TeamsFragment : Fragment() {

    lateinit var cricketRv:RecyclerView
    lateinit var thugsRv:RecyclerView
    lateinit var volleyballRv:RecyclerView
    lateinit var chessRv:RecyclerView
    lateinit var runningRv:RecyclerView
    lateinit var carromRv:RecyclerView
    lateinit var batmintonRv:RecyclerView

    private val cricketAdapters by lazy {
        TeamsAdapters()
    }

    private val volleyBallAdapters by lazy {
        TeamsAdapters()
    }

    private val batmintonAdapters by lazy {
        TeamsAdapters()
    }

    private val towAdapters by lazy {
        TeamsAdapters()
    }

    private val chessAdapters by lazy {
        TeamsAdapters()
    }

    private val carromAdapters by lazy {
        TeamsAdapters()
    }

    private val runningAdapters by lazy {
        TeamsAdapters()
    }

    private val teamsFragmentViewModel by viewModels<TeamsFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        teamsFragmentViewModel.teams.observe(this) {
            when (it) {
               is Resource.Loading -> {
                    // show progress dialog
                   progressBar3.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar3.visibility = View.INVISIBLE
                    filterCategories(it.data)
                    makeTitleVisible()

                }
                is Resource.Failure -> {
                    progressBar3.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(),it.error,Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    private fun filterCategories(allTeams:ArrayList<Team>){

        volleyBallAdapters.setData( allTeams.filter { it->it.category=="volleyball" } as ArrayList<Team>)
        runningAdapters.setData(allTeams.filter { it->it.category=="running" } as ArrayList<Team>)
        chessAdapters.setData(allTeams.filter { it->it.category=="chess" } as ArrayList<Team>)
        carromAdapters.setData(allTeams.filter { it->it.category=="carrom" } as ArrayList<Team>)
        batmintonAdapters.setData(allTeams.filter { it->it.category=="batminton" } as ArrayList<Team>)
        towAdapters.setData(allTeams.filter { it->it.category=="tug of war" } as ArrayList<Team>)
        cricketAdapters.setData(allTeams.filter { it->it.category == "cricket" } as ArrayList<Team>)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_teams, container, false)
        cricketRv = view.findViewById(R.id.cricket_rv)
        thugsRv = view.findViewById(R.id.tow_rv)
        batmintonRv = view.findViewById(R.id.batminton_rv)
        runningRv = view.findViewById(R.id.running_rv)
        chessRv = view.findViewById(R.id.chess_rv)
        carromRv = view.findViewById(R.id.carromboard_rv)
        volleyballRv = view.findViewById(R.id.volleyball_rv)
        setCommonAdapters(cricketAdapters,cricketRv)
        setCommonAdapters(towAdapters,thugsRv)
        setCommonAdapters(batmintonAdapters,batmintonRv)
        setCommonAdapters(runningAdapters,runningRv)
        setCommonAdapters(chessAdapters,chessRv)
        setCommonAdapters(carromAdapters,carromRv)
        setCommonAdapters(volleyBallAdapters,volleyballRv)



        return view
    }

    private fun setCommonAdapters(
        adapters: TeamsAdapters,
        recyclerView: RecyclerView
    ){


        recyclerView.visibility = View.VISIBLE

        recyclerView.adapter = adapters
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = lm

    }

    fun makeTitleVisible(){
        cricket_teams_title.visibility = View.VISIBLE
        volleyball_team_title.visibility = View.VISIBLE
        thugs_war_title.visibility = View.VISIBLE
        batminton_team_title.visibility = View.VISIBLE
        chess_team_title.visibility = View.VISIBLE
        running_team_title.visibility = View.VISIBLE
        carrom_team_title.visibility = View.VISIBLE

    }


}