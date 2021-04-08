package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

/**
 * A  [Fragment] subclass.
 * Use the [AgeFragment.newInstance] factory method to
 * collect the age of the patient
 */
class AgeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_age, container, false)

        val Button = view?.findViewById<Button>(R.id.age_next_button) as TextView
        Button.setOnClickListener {
            // get the fragment instance
            val nextFragment = GenderFragment()
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