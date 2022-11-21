package com.example.gusports.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gusports.R
import com.example.gusports.models.DateMatches
import kotlinx.android.synthetic.main.match_section_item_row.view.*

class MatchSectionAdapters:RecyclerView.Adapter<MatchSectionAdapters.MyViewHolder>() {

    private var dateMatches = arrayListOf<DateMatches>()

    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.match_section_item_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dateMatches[position]
        holder.itemView.match_date.text = item.date

        val matchRowAdapters = MatchRowAdapters(item.matches!!)

        holder.itemView.section_matches_rv.adapter = matchRowAdapters
        holder.itemView.section_matches_rv.layoutManager = LinearLayoutManager(holder.itemView.context)

    }

    fun setData(dateMatches: ArrayList<DateMatches>){
        this.dateMatches = dateMatches
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dateMatches.size
}