package com.example.quotespie.fregment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotespie.Adapter.Save_Adapter
import com.example.quotespie.DBHelper.DBhelper
import com.example.quotespie.databinding.FragmentSaveBinding
import com.example.quotespie.modal_class.Quotes_ModalClass

lateinit var bindingSaveFragment: FragmentSaveBinding
var savaList = ArrayList<Quotes_ModalClass>()
class SaveFragment : Fragment() {

    lateinit var db: DBhelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingSaveFragment =  FragmentSaveBinding.inflate(inflater, container, false)

        rvData()
        db = DBhelper(requireContext())
        savaList = db.getQuotes()

        return bindingSaveFragment.root
    }

    private fun rvData() {
        var adapter = Save_Adapter(requireContext(), savaList)
        var lm = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        bindingSaveFragment.rvdataSave.layoutManager = lm
        bindingSaveFragment.rvdataSave.adapter = adapter
    }


}

