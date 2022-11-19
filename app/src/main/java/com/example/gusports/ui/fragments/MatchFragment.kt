package com.example.gusports.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.ui.adapters.MatchSectionAdapters
import com.example.gusports.models.DateMatches
import com.example.gusports.models.Matches
import com.example.gusports.utils.Resource
import com.example.gusports.viewmodels.MatchFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.android.synthetic.main.fragment_match.*

@AndroidEntryPoint
class MatchFragment : Fragment() {

    lateinit var dateMatchesRv:RecyclerView
    private val matchSectionAdapters by lazy {
        MatchSectionAdapters()
    }
    private val matchFragmentViewModel by viewModels<MatchFragmentViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    matchFragmentViewModel.matches.observe(this, Observer {
        when(it){
            is Resource.Loading->{
                progressBar.visibility=View.VISIBLE
            }
            is Resource.Success->{
                progressBar.visibility=View.INVISIBLE
                matchSectionAdapters.setData(it.data)
            }

            is Resource.Failure->{
                progressBar.visibility=View.INVISIBLE
                Toast.makeText(requireContext(),it.error,Toast.LENGTH_SHORT).show()
            }
        }

    })


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

    }


}