package com.bignerdranch.android.covidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [QBFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class QBFragment : Fragment() {
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var nextButton: Button
    private  var questionTextView =view?.findViewById<TextView>(R.id.question_text_view)
    var currentIndex = 1
    val list = arrayListOf<String>("Asthma","Cardio" , "Lung", "Immune", "Metaba", "Neuro", "Other",
    "Auto", "Obesity", "Pregnant", "Renal", "Gastro", "Hyper")
    private val FragquestionBank = listOf(
        Questions(R.string.question_asthma, Patient.Asthma),
        Questions(R.string.question_cardiovascular, Patient.Cardio),
        Questions(R.string.question_lung, Patient.Lung),
        Questions(R.string.question_immune, Patient.Immune),
        Questions(R.string.question_metabolic, Patient.Metaba),
        Questions(R.string.question_neurologic, Patient.Neuro),
        Questions(R.string.question_other, Patient.Other),
        Questions(R.string.question_autoimmune, Patient.Auto),
        Questions(R.string.question_obesity, Patient.Obesity),
        Questions(R.string.question_pregnancy, Patient.Pregnant),
        Questions(R.string.question_renal, Patient.Renal),
        Questions(R.string.question_liver, Patient.Gastro),
        Questions(R.string.question_hypertension, Patient.Hyper)
    )

    private val covidViewModel: CovidViewModel by lazy{
        ViewModelProviders.of(this).get(CovidViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_q_b, container, false)

        val yesButton = view?.findViewById<Button>(R.id.yes_button) as TextView
        val noButton = view?.findViewById<Button>(R.id.no_button) as TextView
        val Button = view?.findViewById<Button>(R.id.qb_next_button) as TextView

        yesButton.setOnClickListener {
            var question = FragquestionBank[currentIndex].answer
            FragquestionBank[currentIndex].answer = true
            if (list[currentIndex-1]=="Asthma")
                Patient.Asthma = true
            if (list[currentIndex-1] == "Cardio")
                Patient.Cardio = true
            if (list[currentIndex-1] == "Lung")
                Patient.Lung = true
            if (list[currentIndex-1] == "Immune")
                Patient.Immune = true
            if (list[currentIndex-1] == "Metaba")
                Patient.Metaba = true
            if (list[currentIndex-1] == "Neuro")
                Patient.Neuro = true
            if (list[currentIndex-1] == "Other")
                Patient.Other = true
            if (list[currentIndex-1] == "Auto")
                Patient.Auto = true
            if (list[currentIndex-1] == "Obesity")
                Patient.Obesity = true
            if (list[currentIndex-1] == "Pregnant")
                Patient.Pregnant = true
            if (list[currentIndex-1] == "Renal")
                Patient.Renal = true
            if (list[currentIndex-1] == "Gastro")
                Patient.Gastro = true
            if (list[currentIndex-1] == "Hyper")
                Patient.Hyper = true
        }

        Button.setOnClickListener {
            val testText = view?.findViewById<TextView>(R.id.question_text_view)

            testText.setText(FragquestionBank[currentIndex].textResId)
            fragmoveToNext()
            updateQuestion()
        }

        // Delete this
        val lastButton = view?.findViewById<Button>(R.id.lastButton) as TextView
        lastButton.setOnClickListener {
            // get the fragment instance
            val nextFragment = DeleteFragment()
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

    }

     fun updateQuestion(){
        // val questionTextResId = questionBank[currentIndex].textResId
        val questionTextResId = fragcurrentQuestionText
         questionTextView?.setText(questionTextResId)
    }
     fun setAnswers(userAnswer: Boolean){
        //send answers to patient class
    }

    val fragcurrentQuestionText: Int
        get() = FragquestionBank[currentIndex].textResId

    fun fragmoveToNext(){
        if(currentIndex == FragquestionBank.lastIndex){
            currentIndex = FragquestionBank.lastIndex
            //
            // Need to transition to confirmation and transfer module
        }
        else {
            currentIndex = currentIndex + 1
        }
    }
}