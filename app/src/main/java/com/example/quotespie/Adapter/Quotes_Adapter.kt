package com.example.quotespie.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotespie.R
import com.example.quotespie.modal_class.Quotes_ModalClass

class Quotes_Adapter(private val context: Context, private val quotesModalclass: ArrayList<Quotes_ModalClass>) :
    RecyclerView.Adapter<Quotes_Adapter.Qoutes_Holder>() {

    class Qoutes_Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var quoteName: TextView = itemView.findViewById(R.id.txtqoutes)
        var authorName: TextView = itemView.findViewById(R.id.txtname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Qoutes_Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.quotes_tile, parent, false)
        return Qoutes_Holder(view)
    }

    override fun getItemCount(): Int {
        return quotesModalclass.size
    }

    override fun onBindViewHolder(holder: Qoutes_Holder, position: Int) {
        holder.quoteName.text =quotesModalclass[position].qoutes_pie
        holder.authorName.text = quotesModalclass[position].qoutes_authorname
        }
}