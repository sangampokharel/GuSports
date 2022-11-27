package com.example.gusports.ui.adapters

import android.service.autofill.FieldClassification.Match
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gusports.R
import com.example.gusports.models.Matches
import kotlinx.android.synthetic.main.matches_item_row.view.*

class MatchRowAdapters(private val matches:ArrayList<Matches?>):RecyclerView.Adapter<MatchRowAdapters.MyViewHolder>() {

    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.matches_item_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = matches[position]!!

        if(item.category == "running"){
            holder.itemView.vs_id.text = "~"
        }
        holder.itemView.home_team_name.text = item.homeTeamName!!.toLowerCase().capitalize()
        holder.itemView.away_team_name.text = item.awayTeamName!!.toLowerCase().capitalize()
        //holder.itemView.contact_person.text = item.gameStatus
        holder.itemView.home_winner_status.text = item.homeWinner
        holder.itemView.away_winner_status.text = item.awayWinner
        holder.itemView.match_venue.text = "${item.venue}"

        if(item.homeTeamLogo!=null){
            Glide.with(holder.itemView).load(item.homeTeamLogo).placeholder(R.color.blue_gray_100).into(holder.itemView.home_team_logo)

        }else{
            holder.itemView.home_team_logo.visibility = View.GONE
        }

        if(item.awayTeamLogo!=null){
            Glide.with(holder.itemView).load(item.awayTeamLogo).placeholder(R.color.blue_gray_100).into(holder.itemView.away_team_logo)

        }else{
            holder.itemView.away_team_logo.visibility = View.GONE
        }



    }



    override fun getItemCount(): Int = matches.size

}