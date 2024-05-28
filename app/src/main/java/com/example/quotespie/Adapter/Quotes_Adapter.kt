package com.example.quotespie.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotespie.DBHelper.DBhelper
import com.example.quotespie.R
import com.example.quotespie.modal_class.Quotes_ModalClass
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener



class Quotes_Adapter(private val context: Context, private val quotesModalclass: ArrayList<Quotes_ModalClass>) :
    RecyclerView.Adapter<Quotes_Adapter.Qoutes_Holder>() {

    private var onLikeClickListener: OnLikeClickListener? = null
//    private val dbHelper = DbHelper(context) // Initialize DbHelper here

    interface OnLikeClickListener {
        fun onLikeClick(position: Int)
    }

    fun setOnLikeClickListener(listener: OnLikeClickListener) {
        this.onLikeClickListener = listener
    }

    class Qoutes_Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var quoteName: TextView = itemView.findViewById(R.id.txtqoutes)
        var authorName: TextView = itemView.findViewById(R.id.txtname)
        var likebtn: ImageView = itemView.findViewById(R.id.imglike)
        var sharebtn: ImageView = itemView.findViewById(R.id.imgshare)
        var save: ImageView = itemView.findViewById(R.id.imgsave)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Qoutes_Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.quotes_tile, parent, false)
        return Qoutes_Holder(view)
    }

    override fun getItemCount(): Int {
        return quotesModalclass.size
    }

    override fun onBindViewHolder(holder: Qoutes_Holder, position: Int) {

        val currentItem: Quotes_ModalClass = quotesModalclass[position]

        holder.quoteName.text = quotesModalclass[position].qoutes_pie
        holder.authorName.text = quotesModalclass[position].qoutes_authorname
        holder.likebtn.setImageResource(R.drawable.heart)
//        var sharebtn: ImageView = itemView.findViewById(R.id.imgshare)


        if (currentItem.like) {
            holder.likebtn.setImageResource(R.drawable.heart_fill)
        } else {
            holder.likebtn.setImageResource(R.drawable.heart)
        }

        holder.likebtn.setOnClickListener {

            val newLikedState = !currentItem.like
//            dbHelper.updateLikedStatus(currentItem.boolean, newLikedState)
            currentItem.like = newLikedState
            notifyItemChanged(position)
            onLikeClickListener?.onLikeClick(position)
        }

        holder.sharebtn.setOnClickListener {
            val quoteText = currentItem.qoutes_pie

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, quoteText)
            context.startActivity(Intent.createChooser(shareIntent, "Share using"))
        }
        holder.save.setOnClickListener {
            var dBhelper = DBhelper(context)
                dBhelper.addQuotes(Quotes_ModalClass("quotes","author","Author 1",false,0))

        }
    }
}