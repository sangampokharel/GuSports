package com.example.gusports.ui.adapters

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gusports.R
import com.example.gusports.models.Sponsor
import kotlinx.android.synthetic.main.sponsor_item_row.view.*


class SponsorsAdapters:RecyclerView.Adapter<SponsorsAdapters.MyViewHolder>() {

    private var sponsors = listOf<Sponsor>()
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sponsor_item_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = sponsors[position]

        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            holder.itemView.context.startActivity(browserIntent)
        }
        try{

            Glide.with(holder.itemView.context).load(item.imageUrl).placeholder(R.color.blue_gray_100).into(holder.itemView.sponsor_img_view)

        }catch (e:Exception){
            Log.d("SPONSOR ADAPTER",e.localizedMessage)
        }
    }

    override fun getItemCount(): Int = sponsors.size

    fun setData(sponsor:List<Sponsor>){
        this.sponsors = sponsor
        notifyDataSetChanged()
    }

}