package com.bignerdranch.android.covidapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.covidapp.repository.Repository


/**
 * A simple [Fragment] subclass.
 * Use the [DeleteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_delete, container, false)




        val one = view.findViewById<TextView>(R.id.Age)
        val two = view.findViewById<TextView>(R.id.Sex)
        val three = view.findViewById<TextView>(R.id.Ethnicity)
        val four = view.findViewById<TextView>(R.id.Asthma)
        val five = view.findViewById<TextView>(R.id.Cardio)
        val six = view.findViewById<TextView>(R.id.Lung)
        val seven = view.findViewById<TextView>(R.id.Immune)
        val eight = view.findViewById<TextView>(R.id.Metaba)
        val nine = view.findViewById<TextView>(R.id.Neuro)
        val ten = view.findViewById<TextView>(R.id.Other)
        val eleven = view.findViewById<TextView>(R.id.Obesity)
        val twelve = view.findViewById<TextView>(R.id.Pregnant)
        val thirteen = view.findViewById<TextView>(R.id.Renal)
        val fourteen = view.findViewById<TextView>(R.id.Gastro)
        val fifteen = view.findViewById<TextView>(R.id.Hyper)
        val sixteen = view.findViewById<TextView>(R.id.Auto)
        one.setText(Patient.age.toString())
        two.setText(Patient.sex.toString())
        three.setText(Patient.ethnicity.toString())
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer{response ->
            if(response.isSuccessful){
                Log.d("Age Response", response.body()?.age.toString())
            }else{
                Log.d("Error response", response.errorBody().toString())
            }
        })
    }

}