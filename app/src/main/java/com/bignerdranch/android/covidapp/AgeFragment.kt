package com.bignerdranch.android.covidapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/**
 * A  [Fragment] subclass.
 * Use the [AgeFragment.newInstance] factory method to
 * collect the age of the patient
 */
class AgeFragment: Fragment()  {

     lateinit var editText: EditText
     var input :Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_age, container, false)

        val Button = view?.findViewById<Button>(R.id.age_next_button) as TextView
        Button.setOnClickListener {
            editText = view.findViewById<EditText>(R.id.editTextNumber2)
            if (!TextUtils.isEmpty(editText.text.toString())) {
                input = Integer.parseInt(editText.text.toString())
                Patient.age = input

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
            } else
                Toast.makeText(getActivity(), "Please enter a number", Toast.LENGTH_SHORT).show()
        }
        // Inflate the layout for this fragment
        return view
    }



}