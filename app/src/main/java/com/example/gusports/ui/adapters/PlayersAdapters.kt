package com.example.gusports.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gusports.R
import com.example.gusports.models.Players
import kotlinx.android.synthetic.main.players_item_row.view.*

class PlayersAdapters:RecyclerView.Adapter<PlayersAdapters.MyViewHolder>() {

    private var players = arrayListOf<Players>()
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.players_item_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayersAdapters.MyViewHolder, position: Int) {
       val item = players[position]
        holder.itemView.players_name.text = item.playerFullName!!.toLowerCase().capitalize()?:"~"
//       if (item.playerContact!! > 0) {
//           holder.itemView.players_contact.text =item.playerContact.toString()
//
//       } else {
//           holder.itemView.players_contact.text =""
//       }
        holder.itemView.players_course.text = item.playersEmail!!?:"~"

        if(item.playerImageUrl!!.trim().isEmpty()){
            Glide.with(holder.itemView).load("https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?w=100&t=st=1669301535~exp=1669302135~hmac=6ccb834d5bc126337397d154fdc9811e9cbcda251c500abde222712fc9df6c13").into(holder.itemView.players_img_url)

        }else{
            Glide.with(holder.itemView).load(item.playerImageUrl).into(holder.itemView.players_img_url)

        }
    }

    fun setData(players:ArrayList<Players>){
        this.players = players
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = players.size

}