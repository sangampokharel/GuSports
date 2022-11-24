package com.example.gusports.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gusports.R
import com.example.gusports.models.Team
import com.example.gusports.ui.activities.RulesDetailsActivity
import com.example.gusports.ui.adapters.RulesAdapters.ViewHolder
import kotlinx.android.synthetic.main.rules_item_row.view.*

class RulesAdapters:RecyclerView.Adapter<ViewHolder>() {

    private var rules = arrayListOf<Team>()
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rules_item_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = rules[position]
        Glide.with(holder.itemView).load(item.teamLogo).into(holder.itemView.rules_logo)
        holder.itemView.game_name.text = item.teamName
        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context,RulesDetailsActivity::class.java)
            i.putExtra("category",item.category)
            i.putExtra("title",item.teamName)
            holder.itemView.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int = rules.size

    fun setData(rules:ArrayList<Team>){
        this.rules = rules
    }
}