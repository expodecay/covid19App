package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders


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
            // get the fragment instance
            val nextFragment = QBFragment()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val updatetext = view?.findViewById<TextView>(R.id.ethnicityTitle)

        val americanIndian = view.findViewById<CheckBox>(R.id.American_Indian)
        americanIndian?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.Ethnicity = americanIndian.text.toString()
            updatetext.setText(Patient.Ethnicity)
        }
        val asian = view.findViewById<CheckBox>(R.id.Asian)
        asian?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.Ethnicity = asian.text.toString()
            updatetext.setText(Patient.Ethnicity)
        }
        val black = view.findViewById<CheckBox>(R.id.Black)
        black?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.Ethnicity = black.text.toString()
            updatetext.setText(Patient.Ethnicity)
        }
        val hispanic = view.findViewById<CheckBox>(R.id.Hispanic)
        hispanic?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.Ethnicity = hispanic.text.toString()
            updatetext.setText(Patient.Ethnicity)
        }
        val pacific = view.findViewById<CheckBox>(R.id.Pacific)
        pacific?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.Ethnicity = pacific.text.toString()
            updatetext.setText(Patient.Ethnicity)
        }
        val white = view.findViewById<CheckBox>(R.id.White)
        white?.setOnCheckedChangeListener { buttonView, isChecked ->
            Patient.Ethnicity = white.text.toString()
            updatetext.setText(Patient.Ethnicity)
        }

    }

}