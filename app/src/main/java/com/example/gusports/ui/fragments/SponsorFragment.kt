package com.example.gusports.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.ui.adapters.SponsorsAdapters
import com.example.gusports.utils.Resource
import com.example.gusports.viewmodels.SponsorsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_sponsor.*

@AndroidEntryPoint
class SponsorFragment : Fragment() {


    private val sponsorsFragmentViewModel by viewModels<SponsorsFragmentViewModel>()
    private val sponsorsAdapters by lazy {
        SponsorsAdapters()
    }
    lateinit var sponsorsRV:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sponsorsFragmentViewModel.sponsors.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    sponsor_progress.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    sponsor_progress.visibility = View.INVISIBLE
                    sponsorsAdapters.setData(it.data)


                }

                is Resource.Failure -> {
                    sponsor_progress.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sponsor, container, false)
        setUpAdapters(view)
        return view
    }

    private fun setUpAdapters(view:View) {

        sponsorsRV = view.findViewById(R.id.sponsors_rv)

        val lm = LinearLayoutManager(requireContext())
        sponsorsRV.layoutManager = lm
        sponsorsRV.adapter = sponsorsAdapters

    }

}