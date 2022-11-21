package com.example.gusports.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.ui.adapters.PlayersAdapters
import com.example.gusports.models.Players


class PlayersFragment : Fragment() {

    private lateinit var playersRv:RecyclerView

    private val playersAdapters by lazy {
        PlayersAdapters()
    }
    private val playersList = arrayListOf<Players>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playersList.add(Players("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR_BSXPlBjoBeJruSaCamv7kQuMNjoIIWX0CITXUVoapFCbRM9g","Messi","1213131313",10,"MSC IT Mobile application","1st year 2nd sem","",""))
        playersList.add(Players("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR_BSXPlBjoBeJruSaCamv7kQuMNjoIIWX0CITXUVoapFCbRM9g","Messi","1213131313",10,"MSC IT Mobile application","1st year 2nd sem","",""))
        playersList.add(Players("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR_BSXPlBjoBeJruSaCamv7kQuMNjoIIWX0CITXUVoapFCbRM9g","Messi","1213131313",10,"MSC IT Mobile application","1st year 2nd sem","",""))
        playersList.add(Players("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR_BSXPlBjoBeJruSaCamv7kQuMNjoIIWX0CITXUVoapFCbRM9g","Messi","1213131313",10,"MSC IT Mobile application","1st year 2nd sem","",""))
        playersList.add(Players("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR_BSXPlBjoBeJruSaCamv7kQuMNjoIIWX0CITXUVoapFCbRM9g","Messi","1213131313",10,"MSC IT Mobile application","1st year 2nd sem","",""))


//        val callback: OnBackPressedCallback =
//            object : OnBackPressedCallback(true /* enabled by default */) {
//                override fun handleOnBackPressed() {
//                    // Handle the back button event
//                }
//            }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_players, container, false)
        setUpPlayersRv(view)
        view.findViewById<ImageView>(R.id.players_back_btn).setOnClickListener {
            findNavController().navigate(R.id.teamsFragment)
        }


        return view
    }

    private fun setUpPlayersRv(view:View){
        playersRv = view.findViewById(R.id.players_rv)
        val lm = LinearLayoutManager(requireContext())
        playersRv.layoutManager=lm
        playersRv.adapter = playersAdapters
        playersAdapters.setData(playersList)
    }


}