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
    private  var questionTextView =view?.findViewById<TextView>(R.id.question_text_view)
    var currentIndex = 1
    val list = arrayListOf<String>("Asthma","Cardio" , "Lung", "Immune", "Metaba", "Neuro", "Other",
    "Auto", "Obesity", "Pregnant", "Renal", "Gastro", "Hyper")
    val fragcurrentQuestionText: Int
        get() = FragquestionBank[currentIndex].textResId

    private val FragquestionBank = listOf(
        Questions(R.string.question_asthma, Patient.asthma),
        Questions(R.string.question_cardiovascular, Patient.cardio),
        Questions(R.string.question_lung, Patient.lung),
        Questions(R.string.question_immune, Patient.immune),
        Questions(R.string.question_metabolic, Patient.metaba),
        Questions(R.string.question_neurologic, Patient.neuro),
        Questions(R.string.question_other, Patient.other),
        Questions(R.string.question_autoimmune, Patient.auto),
        Questions(R.string.question_obesity, Patient.obesity),
        Questions(R.string.question_pregnancy, Patient.pregnant),
        Questions(R.string.question_renal, Patient.renal),
        Questions(R.string.question_liver, Patient.gastro),
        Questions(R.string.question_hypertension, Patient.hyper)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_q_b, container, false)

        val yesButton = view?.findViewById<Button>(R.id.yes_button) as TextView
        val Button = view?.findViewById<Button>(R.id.qb_next_button) as TextView

        yesButton.setOnClickListener {
            if (list[currentIndex-1]=="Asthma")
                Patient.asthma = 1
            if (list[currentIndex-1] == "Cardio")
                Patient.cardio = 1
            if (list[currentIndex-1] == "Lung")
                Patient.lung = 1
            if (list[currentIndex-1] == "Immune")
                Patient.immune = 1
            if (list[currentIndex-1] == "Metaba")
                Patient.metaba = 1
            if (list[currentIndex-1] == "Neuro")
                Patient.neuro = 1
            if (list[currentIndex-1] == "Other")
                Patient.other = 1
            if (list[currentIndex-1] == "Auto")
                Patient.auto = 1
            if (list[currentIndex-1] == "Obesity")
                Patient.obesity = 1
            if (list[currentIndex-1] == "Pregnant")
                Patient.pregnant = 1
            if (list[currentIndex-1] == "Renal")
                Patient.renal = 1
            if (list[currentIndex-1] == "Gastro")
                Patient.gastro = 1
            if (list[currentIndex-1] == "Hyper")
                Patient.hyper = 1
        }

        Button.setOnClickListener {
            val testText = view?.findViewById<TextView>(R.id.question_text_view)

            testText.setText(FragquestionBank[currentIndex].textResId)
            fragmoveToNext()
            updateQuestion()
        }

        // Delete this------------------------------------------------------------------------------
        val lastButton = view?.findViewById<Button>(R.id.showInput) as TextView
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
        //------------------------------------------------------------------------------------------
        // Inflate the layout for this fragment

      //  Patient.sendForm()      // uses Retrofit

        return view
    }

     fun updateQuestion(){
        // val questionTextResId = questionBank[currentIndex].textResId
        val questionTextResId = fragcurrentQuestionText
         questionTextView?.setText(questionTextResId)
    }

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