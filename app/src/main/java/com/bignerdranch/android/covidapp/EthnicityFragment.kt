package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [EthnicityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EthnicityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ethnicity, container, false)
        val Button = view?.findViewById<Button>(R.id.ethnicity_next_button) as TextView
        Button.setOnClickListener {
            val nextFragment = QBFragment()
            val manager = (context as MainActivity).supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frameLayout, nextFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        val updatetext = view?.findViewById<TextView>(R.id.ethnicityTitle)

        val americanIndian = view.findViewById<CheckBox>(R.id.American_Indian)
        americanIndian?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.ethnicity = americanIndian.text.toString()
            updatetext.setText(Patient.ethnicity)
        }
        val asian = view.findViewById<CheckBox>(R.id.Asian)
        asian?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.ethnicity = asian.text.toString()
            updatetext.setText(Patient.ethnicity)
        }
        val black = view.findViewById<CheckBox>(R.id.Black)
        black?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.ethnicity = black.text.toString()
            updatetext.setText(Patient.ethnicity)
        }
        val hispanic = view.findViewById<CheckBox>(R.id.Hispanic)
        hispanic?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.ethnicity = hispanic.text.toString()
            updatetext.setText(Patient.ethnicity)
        }
        val pacific = view.findViewById<CheckBox>(R.id.Pacific)
        pacific?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.ethnicity = pacific.text.toString()
            updatetext.setText(Patient.ethnicity)
        }
        val white = view.findViewById<CheckBox>(R.id.White)
        white?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.ethnicity = white.text.toString()
            updatetext.setText(Patient.ethnicity)
        }

 */
    }
}