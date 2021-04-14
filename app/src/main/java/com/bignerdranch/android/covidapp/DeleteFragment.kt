package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [DeleteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_delete, container, false)

        val one = view.findViewById<TextView>(R.id.Age) as TextView
        val two = view.findViewById<TextView>(R.id.Sex) as TextView
        val three = view.findViewById<TextView>(R.id.Ethnicity) as TextView
        val four = view.findViewById<TextView>(R.id.Asthma) as TextView
        val five = view.findViewById<TextView>(R.id.Cardio) as TextView
        val six = view.findViewById<TextView>(R.id.Lung) as TextView
        val seven = view.findViewById<TextView>(R.id.Immune) as TextView
        val eight = view.findViewById<TextView>(R.id.Metaba) as TextView
        val nine = view.findViewById<TextView>(R.id.Neuro) as TextView
        val ten = view.findViewById<TextView>(R.id.Other) as TextView
        val eleven = view.findViewById<TextView>(R.id.Obesity) as TextView
        val twelve = view.findViewById<TextView>(R.id.Pregnant) as TextView
        val thirteen = view.findViewById<TextView>(R.id.Renal) as TextView
        val fourteen = view.findViewById<TextView>(R.id.Gastro) as TextView
        val fifteen = view.findViewById<TextView>(R.id.Hyper) as TextView
        val sixteen = view.findViewById<TextView>(R.id.Auto) as TextView

        one.setText(Patient.Age)
        two.setText(Patient.Sex)
        three.setText(Patient.Ethnicity)
        four.setText(Patient.Asthma.toString())
        five.setText(Patient.Cardio.toString())
        six.setText(Patient.Lung.toString())
        seven.setText(Patient.Immune.toString())
        eight.setText(Patient.Metaba.toString())
        nine.setText(Patient.Neuro.toString())
        ten.setText(Patient.Other.toString())
        eleven.setText(Patient.Obesity.toString())
        twelve.setText(Patient.Pregnant.toString())
        thirteen.setText(Patient.Renal.toString())
        fourteen.setText(Patient.Gastro.toString())
        fifteen.setText(Patient.Hyper.toString())
        sixteen.setText(Patient.Auto.toString())


        // Inflate the layout for this fragment
        return view
    }


}