package com.example.quotespie.fregment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotespie.Adapter.Quotes_Adapter
import com.example.quotespie.databinding.FragmentHomeBinding
import com.example.quotespie.modal_class.Quotes_ModalClass

lateinit var homeBinding: FragmentHomeBinding
var quotesModalclass = ArrayList<Quotes_ModalClass>()

class HomeFragment : Fragment() {

  //  lateinit var db: DBhelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeBinding =
            FragmentHomeBinding.inflate(inflater, container, false) //InflateThe Binding Object

        // Inflate the layout for this fragment

        // Qoutes
        val qoutes_pie = arrayOf(
            "Success is the sum of small efforts - repeated day in and day out.",
            "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.",
            "Strive not to be a success, but rather to be of value.",
            "Success consists of going from failure to failure without loss of enthusiasm.",
            "Always be yourself, express yourself, have faith in yourself, do not go out and look for a successful personality and duplicate it.",
            "Coming together is a beginning; keeping together is progress; working together is success.",
            "If everyone is moving forward together, then success takes care of itself.",
            "Doubt kills more dreams than failure ever will.",
            "Our greatest glory is not in never falling, but in rising every time we fall.",
            "I can accept failure, everyone fails at something. But I can't accept not trying."
        )
        // Author Name
        val qoutes_authorname = arrayOf(
            "- Robert Collier",
            " - Albert Schweitzer",
            "- Albert Einstein",
            "- Winston Churchill",
            "- Bruce Lee",
            "- Edward Everett Hale",
            "- Henry Ford",
            "– Suzy Kassem",
            "- Confucius",
            "- Michael Jordan"
        )

        // Modal Class For Loop
        for (i in qoutes_pie.indices) {
            val qoutes =
                Quotes_ModalClass(qoutes_pie[i], qoutes_authorname[i], "Author 1", false, id)
            quotesModalclass.add(qoutes)
        }



        val quotesAdapter = Quotes_Adapter(
            requireContext(),
            quotesModalclass
        ) // Adapeter : Note the Corrected Adapter Name
        // val layoutManager = GridLayoutManager(requireContext(),1)
        var layoutManager = LinearLayoutManager(requireContext())
        homeBinding.rvdata.layoutManager = layoutManager
        homeBinding.rvdata.adapter = quotesAdapter

        return homeBinding.root // Return the root view of the binding object
    }


}