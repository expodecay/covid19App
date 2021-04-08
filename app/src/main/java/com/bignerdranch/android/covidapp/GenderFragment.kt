package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [GenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GenderFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_gender, container, false)

        val Button = view?.findViewById<Button>(R.id.gender_next_button) as TextView
        Button.setOnClickListener {
            // get the fragment instance
            val nextFragment = EthnicityFragment()
            // get the support fragment manager instance
            val manager = (context as MainActivity).supportFragmentManager
            // begin fragment transaction using fragment manager
            val transaction = manager.beginTransaction()
            // replace fragment in the container and finish the transaction
            transaction.replace(R.id.frameLayout, nextFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
            // Inflate the layout for this fragment
            return view
    }


}