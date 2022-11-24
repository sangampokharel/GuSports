package com.example.gusports.ui.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gusports.R
import com.example.gusports.models.Team
import com.example.gusports.ui.activities.PlayersActivity
import kotlinx.android.synthetic.main.teams_item_row.view.*

class TeamsAdapters:RecyclerView.Adapter<TeamsAdapters.MyViewHolder>() {

    private var teams = arrayListOf<Team>()


    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val itemName = view.teams_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.teams_item_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val item = teams[position]
       holder.itemName.text = item.teamName
        Glide.with(holder.itemView).load(item.teamLogo).into(holder.itemView.teams_logo)

        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context,PlayersActivity::class.java)
            i.putExtra("category",item.category)
            i.putExtra("teamid",item.teamId)
            holder.itemView.context.startActivity(i)
        }


    }

    fun setData(teams:ArrayList<Team>){
        this.teams = teams
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = teams.size


}