package com.example.gusports.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.ui.adapters.MatchSectionAdapters
import com.example.gusports.ui.models.DateMatches
import com.example.gusports.ui.models.Matches


class MatchFragment : Fragment() {

    lateinit var dateMatchesRv:RecyclerView
    private val matchSectionAdapters by lazy {
        MatchSectionAdapters()
    }
    private val dateMatches = arrayListOf<DateMatches>()
    private val matches = arrayListOf<Matches>()
    private val matches1 = arrayListOf<Matches>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        matches.add(
            Matches(
                "https://assets.manutd.com/AssetPicker/images/0/0/3/2/197240/Header-Logo1500994616801.png",
            "https://www.liverpoolfc.com/liverpoolfc_crest.png",
            "Ttitan",
            "Warriors",
            "12:00 AM",
            "Not Started",
            "winner",
            "",
            "Gujarat University Ground",
            "",
            "7485970908"
        ))

        matches.add(
            Matches(
                "https://assets.manutd.com/AssetPicker/images/0/0/3/2/197240/Header-Logo1500994616801.png",
                "https://www.liverpoolfc.com/liverpoolfc_crest.png",
                "Ttitan",
                "Warriors",
                "12:00 AM",
                "running",
                "winner",
                "",
                "Gujarat University Ground",
                "",
                "7485970908"
            ))


        matches1.add(
            Matches(
                "https://assets.manutd.com/AssetPicker/images/0/0/3/2/197240/Header-Logo1500994616801.png",
                "https://www.liverpoolfc.com/liverpoolfc_crest.png",
                "Ttitan",
                "Warriors",
                "12:00 AM",
                "running",
                "winner",
                "",
                "Gujarat University Ground",
                "",
                "7485970908"
            ))


        matches1.add(
            Matches(
                "https://assets.manutd.com/AssetPicker/images/0/0/3/2/197240/Header-Logo1500994616801.png",
                "https://www.liverpoolfc.com/liverpoolfc_crest.png",
                "Ttitan",
                "Warriors",
                "12:00 AM",
                "Not started",
                "winner",
                "",
                "Gujarat University Ground",
                "",
                "7485970908"
            ))

        dateMatches.add(DateMatches("02/12/2022",matches))
        dateMatches.add(DateMatches("02/12/2022",matches1))
        dateMatches.add(DateMatches("02/12/2022",matches))
        dateMatches.add(DateMatches("02/12/2022",matches1))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_match, container, false)
        setUpAdapters(view)
        return view
    }

    fun setUpAdapters(view:View){
        dateMatchesRv = view.findViewById(R.id.section_matches_rv)
        val lm = LinearLayoutManager(requireContext())
        dateMatchesRv.layoutManager = lm
        dateMatchesRv.adapter = matchSectionAdapters

        matchSectionAdapters.setData(dateMatches)

    }


}