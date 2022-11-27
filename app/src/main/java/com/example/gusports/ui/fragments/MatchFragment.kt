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
import com.example.gusports.utils.Resource
import com.example.gusports.viewmodels.MatchFragmentViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_match.*

@AndroidEntryPoint
class MatchFragment : Fragment() {

    lateinit var dateMatchesRv: RecyclerView
    lateinit var matchFloatingActionButton: FloatingActionButton
    private val matchSectionAdapters by lazy {
        MatchSectionAdapters()
    }
    var lastSelectedTab:Int = 0
    var selectedTab = "cricket";
    private val matchFragmentViewModel by viewModels<MatchFragmentViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        matchFragmentViewModel.matches.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    val data = it.data.reversed()
                     matchSectionAdapters.setData(data)
                }

                is Resource.Failure -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(), it.error, Toast.LENGTH_SHORT).show()

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
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        matchFloatingActionButton = view.findViewById(R.id.refresh_btn)


        matchFloatingActionButton.setOnClickListener {
            matchFragmentViewModel.getMatches(selectedTab)
        }

        tabLayout.selectTab(tabLayout.getTabAt(lastSelectedTab))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                matchFragmentViewModel.getMatches(tab?.text.toString().toLowerCase())
                lastSelectedTab = tab?.position!!
                selectedTab = tab?.text.toString().toLowerCase()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        setUpAdapters(view)
        return view
    }

    private fun setUpAdapters(view: View) {
        dateMatchesRv = view.findViewById(R.id.section_matches_rv)
        val lm = LinearLayoutManager(requireContext())
        dateMatchesRv.layoutManager = lm
        dateMatchesRv.adapter = matchSectionAdapters

    }


}