package com.example.gusports.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.models.Team
import com.example.gusports.ui.adapters.RulesAdapters
import kotlinx.android.synthetic.main.fragment_rules.*


class RulesFragment : Fragment() {

    private val rulesAdapters by lazy {
        RulesAdapters()
    }
    private val rules:ArrayList<Team> = arrayListOf()
    lateinit var rulesRecyclerView: RecyclerView
 override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
    rules.add(Team("","https://img.freepik.com/free-vector/ipl-cricket-illustration-hand-drawn-style_23-2149201607.jpg?w=200","Cricket","cricket"))
    rules.add(Team("","https://media.istockphoto.com/id/1305292811/vector/concept-illustration-of-playing-volleyball.jpg?s=612x612&w=0&k=20&c=DV4anVsPjP9q4icvOHPDsYvYG9JreFHwYgkSvqXdbSA=","Volleyball","volleyball"))
    rules.add(Team("","https://thumbs.dreamstime.com/b/couple-businessman-woman-tug-war-tug-war-113563454.jpg","Tug Of War","tug of war"))
    rules.add(Team("","https://media.istockphoto.com/id/1305966517/vector/playing-badminton-illustration.jpg?s=612x612&w=0&k=20&c=L2yRBybtI3t6cZYtfm_21cWBh9AqlJq2Xj_A5h5kdSo=","Badminton","batminton"))
    rules.add(Team("","https://static.vecteezy.com/system/resources/thumbnails/002/267/452/small_2x/runner-running-together-on-illustration-graphic-free-vector.jpg","Running","running"))
    rules.add(Team("","https://www.bluepixeltech.com/assets/front/img/solutions/Red%20Square%20chess%20illustration.png","Chess","chess"))
    rules.add(Team("","https://carrom.com.ua/wp-content/uploads/2016/01/670px-Play-Carrom-Step-2-668x381.jpg","Carrom","carrom"))
     rulesAdapters.setData(rules)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rules, container, false)
       rulesRecyclerView = view.findViewById<RecyclerView>(R.id.rules_rv)
        rulesRecyclerView.adapter =rulesAdapters
        val lm = GridLayoutManager(requireContext(),2)
        rulesRecyclerView.layoutManager = lm
        return view
    }

}