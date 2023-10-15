package com.example.musicapp

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context:Activity, val dataList: List<Data>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val Image  : ImageView
        val Title : TextView
        val play : ImageButton
        val pause : ImageButton

        init {
            Image = itemView.findViewById(R.id.musicImage)
            Title = itemView.findViewById(R.id.musicTitle)
            play = itemView.findViewById(R.id.btnPlay)
            pause = itemView.findViewById(R.id.btnPause)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return  MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return  dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentData = dataList[position]

        holder.Title.text = currentData.title

        Picasso.get().load(currentData.album.cover).into(holder.Image);

        val mediaPlayer = MediaPlayer.create(context,currentData.preview.toUri())

        holder.play.setOnClickListener{
            mediaPlayer.start()
        }

        holder.pause.setOnClickListener{
            mediaPlayer.stop()
        }
    }
}