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

        one.setText(Patient.age)
        two.setText(Patient.sex)
        three.setText(Patient.ethnicity)
        four.setText(Patient.asthma.toString())
        five.setText(Patient.cardio.toString())
        six.setText(Patient.lung.toString())
        seven.setText(Patient.immune.toString())
        eight.setText(Patient.metaba.toString())
        nine.setText(Patient.neuro.toString())
        ten.setText(Patient.other.toString())
        eleven.setText(Patient.obesity.toString())
        twelve.setText(Patient.pregnant.toString())
        thirteen.setText(Patient.renal.toString())
        fourteen.setText(Patient.gastro.toString())
        fifteen.setText(Patient.hyper.toString())
        sixteen.setText(Patient.auto.toString())


        // Inflate the layout for this fragment
        return view
    }


}