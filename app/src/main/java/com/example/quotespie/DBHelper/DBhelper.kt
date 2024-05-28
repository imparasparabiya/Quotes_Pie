package com.example.quotespie.DBHelper

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.quotespie.modal_class.Quotes_ModalClass

class DBhelper(context: Context) :SQLiteOpenHelper(context,"Quotes_pi",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
       val query = "CREATE TABLE Quotes(id INTEGER PRIMARY KEY AUTOINCREMENT, quotespi TEXT, auother TEXT)"
       db!!.apply {
           execSQL(query)
       }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun addQuotes(modal: Quotes_ModalClass){
        val db = readableDatabase
        val cn = ContentValues()

        cn.put("quotes",modal.qoutes_pie)
        cn.put("author",modal.qoutes_authorname)

        db.insert("Quotes",null,cn)
    }
    @SuppressLint("Range")
    fun getQuotes():ArrayList<Quotes_ModalClass>{
        var db = readableDatabase
        var query = "SELECT * FROM Quotes"
        var cursor = db.rawQuery(query,null)
        var detail = ArrayList<Quotes_ModalClass>()
        if (cursor.moveToFirst()){
            do {
                    var id = cursor.getString(cursor.getColumnIndex("id"))
                    var qoutes_pie = cursor.getString(cursor.getColumnIndex("quotes"))
                    var qoutes_authorname = cursor.getString(cursor.getColumnIndex("author"))

                var modal = Quotes_ModalClass(id,qoutes_pie,qoutes_authorname,true,0)
                detail.add(modal)
            }while (cursor.moveToNext())
        }
        return detail
    }

}