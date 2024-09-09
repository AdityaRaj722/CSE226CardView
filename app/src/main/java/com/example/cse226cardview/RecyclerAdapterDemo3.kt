package com.example.cse226cardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterDemo3(var c: Context, var l:MutableList<RecyclerModelDemo3>)
    : RecyclerView.Adapter<RecyclerAdapterDemo3.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: View = LayoutInflater.from(c).inflate(R.layout.customrecyclerlook3, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
        return l.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text = l[position].t
        holder.image.setImageResource(l[position].i)
//        holder.button.setOnClickListener {
//            Toast.makeText(c,"Deleted"+l[position].t,Toast.LENGTH_SHORT).show()
//            l.removeAt(position)
//            notifyDataSetChanged()
//
//        }
        holder.itemView.setOnClickListener{
            Toast.makeText(c,""+l[position].t,Toast.LENGTH_SHORT).show()
        }
    }

    class MyHolder(var v: View) : RecyclerView.ViewHolder(v) {
        var name = v.findViewById<TextView>(R.id.name)
        var image = v.findViewById<ImageView>(R.id.image)
        var button=v.findViewById<Button>(R.id.btn)
    }
}