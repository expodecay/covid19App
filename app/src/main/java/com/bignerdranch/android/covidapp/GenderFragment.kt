package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
            if(Patient.sex == 0)
                Toast.makeText(activity, "Please select a gender", Toast.LENGTH_SHORT).show()
            else {
                val nextFragment = QBFragment()
                val manager = (context as MainActivity).supportFragmentManager
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.frameLayout, nextFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
            return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val maleButton = view.findViewById<Button>(R.id.male_button) as TextView
        val femaleButton = view.findViewById<Button>(R.id.female_button) as TextView

        maleButton.setOnClickListener {
            Patient.sex = 2
            maleButton.isEnabled = false
            femaleButton.isEnabled = true
        }

        femaleButton.setOnClickListener {
            Patient.sex = 1
            femaleButton.isEnabled = false
            maleButton.isEnabled = true
        }
    }
}