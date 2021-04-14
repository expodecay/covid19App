package com.bignerdranch.android.covidapp

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import org.w3c.dom.Text

/**
 * A  [Fragment] subclass.
 * Use the [AgeFragment.newInstance] factory method to
 * collect the age of the patient
 */
class AgeFragment: Fragment()  {


    lateinit var editText: EditText
    lateinit var input :String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_age, container, false)

        val Button = view?.findViewById<Button>(R.id.age_next_button) as TextView
        Button.setOnClickListener {

            editText = view.findViewById<EditText>(R.id.editTextNumber2)
            input = editText.text.toString()
            Patient.Age = input

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