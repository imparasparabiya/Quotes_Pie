package com.example.quotespie.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.quotespie.R
import com.example.quotespie.modal_class.Quotes_ModalClass

class Save_Adapter(val context: Context, var saveList: List<Quotes_ModalClass>) :
    RecyclerView.Adapter<Save_Adapter.SaveViewHoldder>() {

    class SaveViewHoldder(itemView: View) : ViewHolder(itemView) {
        var qoutes = itemView.findViewById<TextView>(R.id.txtqoutes)
        var author = itemView.findViewById<TextView>(R.id.txtname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHoldder {
        val view = LayoutInflater.from(context).inflate(R.layout.quotes_tile, parent, false)
        return SaveViewHoldder(view)
    }

    override fun getItemCount(): Int {
        return saveList.size
    }

    override fun onBindViewHolder(holder: SaveViewHoldder, position: Int) {
            holder.qoutes.text = saveList[position].qoutes_pie
            holder.author.text = saveList[position].qoutes_authorname
        }
}