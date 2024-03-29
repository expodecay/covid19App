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
 * Use the [QBFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class QBFragment : Fragment() {
    private  var questionTextView =view?.findViewById<TextView>(R.id.question_text_view)
    var currentIndex = 1
    val list = arrayListOf<String>("patient_type","intubed" , "pneumonia", "pregnancy", "diabetes", "copd", "asthma",
    "inmsupr", "hypertension", "other_disease", "cardiovascular", "obesity", "renal_chronic", "tobacco", "contact_other_covid", "icu")
    val fragcurrentQuestionText: Int
        get() = FragquestionBank[currentIndex].textResId

    private val FragquestionBank = listOf(
        Questions(R.string.question_patient_type, Patient.patient_type),
        Questions(R.string.question_intubed, Patient.intubed),
        Questions(R.string.question_pneumonia, Patient.pneumonia),
        Questions(R.string.question_pregnancy, Patient.pregnancy),
        Questions(R.string.question_diabetes, Patient.diabetes),
        Questions(R.string.question_copd, Patient.copd),
        Questions(R.string.question_asthma, Patient.asthma),
        Questions(R.string.question_immune, Patient.inmsupr),
        Questions(R.string.question_hypertension, Patient.hypertension),
        Questions(R.string.question_other, Patient.other_disease),
        Questions(R.string.question_cardiovascular, Patient.cardiovascular),
        Questions(R.string.question_obesity, Patient.obesity),
        Questions(R.string.question_renal, Patient.renal_chronic),
        Questions(R.string.question_tobacco, Patient.tobacco),
        Questions(R.string.question_contact, Patient.contact_other_covid),
        Questions(R.string.question_icu, Patient.icu)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_q_b, container, false)

        val yesButton = view?.findViewById<Button>(R.id.yes_button) as TextView
        val noButton = view?.findViewById<Button>(R.id.no_button) as TextView
        val nextButton = view?.findViewById<Button>(R.id.qb_next_button) as TextView

        yesButton.setOnClickListener {
            if (list[currentIndex-1]=="patient_type")
                Patient.patient_type = 2
            if (list[currentIndex-1] == "intubed")
                Patient.intubed = 1
            if (list[currentIndex-1] == "pneumonia")
                Patient.pneumonia = 1
            if (list[currentIndex-1] == "pregnancy")
                Patient.pregnancy = 1
            if (list[currentIndex-1] == "diabetes")
                Patient.diabetes = 1
            if (list[currentIndex-1] == "copd")
                Patient.copd = 1
            if (list[currentIndex-1] == "asthma")
                Patient.asthma = 1
            if (list[currentIndex-1] == "inmsupr")
                Patient.inmsupr = 1
            if (list[currentIndex-1] == "hypertension")
                Patient.hypertension = 1
            if (list[currentIndex-1] == "other_disease")
                Patient.other_disease = 1
            if (list[currentIndex-1] == "cardiovascular")
                Patient.cardiovascular = 1
            if (list[currentIndex-1] == "obesity")
                Patient.obesity = 1
            if (list[currentIndex-1] == "renal_chronic")
                Patient.renal_chronic = 1
            if (list[currentIndex-1] == "tobacco")
                Patient.tobacco = 1
            if (list[currentIndex-1] == "contact_other_covid")
                Patient.contact_other_covid = 1
            if (list[currentIndex-1] == "icu")
                Patient.icu = 1
            yesButton.isEnabled = false
            noButton.isEnabled = true
        }
        noButton.setOnClickListener {
            if (list[currentIndex-1]=="patient_type")
                Patient.patient_type = 1
            if (list[currentIndex-1] == "intubed")
                Patient.intubed = 2
            if (list[currentIndex-1] == "pneumonia")
                Patient.pneumonia = 2
            if (list[currentIndex-1] == "pregnancy")
                Patient.pregnancy = 2
            if (list[currentIndex-1] == "diabetes")
                Patient.diabetes = 2
            if (list[currentIndex-1] == "copd")
                Patient.copd = 2
            if (list[currentIndex-1] == "asthma")
                Patient.asthma = 2
            if (list[currentIndex-1] == "inmsupr")
                Patient.inmsupr = 2
            if (list[currentIndex-1] == "hypertension")
                Patient.hypertension = 2
            if (list[currentIndex-1] == "other_disease")
                Patient.other_disease = 2
            if (list[currentIndex-1] == "cardiovascular")
                Patient.cardiovascular = 2
            if (list[currentIndex-1] == "obesity")
                Patient.obesity = 1
            if (list[currentIndex-1] == "renal_chronic")
                Patient.renal_chronic = 2
            if (list[currentIndex-1] == "tobacco")
                Patient.tobacco = 2
            if (list[currentIndex-1] == "contact_other_covid")
                Patient.contact_other_covid = 2
            if (list[currentIndex-1] == "icu")
                Patient.icu = 2
            yesButton.isEnabled = true
            noButton.isEnabled = false
        }

        nextButton.setOnClickListener {
            if (yesButton.isEnabled && noButton.isEnabled)
                Toast.makeText(activity, "Please select yes or no", Toast.LENGTH_SHORT)
            else {
                val questionText = view?.findViewById<TextView>(R.id.question_text_view)
                questionText.setText(FragquestionBank[currentIndex].textResId)
                yesButton.isEnabled = true
                noButton.isEnabled = true
                updateQuestion()
            }
            if(currentIndex == FragquestionBank.lastIndex) nextButton.isEnabled = false
        }

        val lastButton = view?.findViewById<Button>(R.id.showInput) as TextView
        lastButton.setOnClickListener {
            val nextFragment = ResponseFragment()
            val manager = (context as MainActivity).supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frameLayout, nextFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        //------------------------------------------------------------------------------------------
        // Inflate the layout for this fragment
        return view
    }

    fun updateQuestion(){
        if(currentIndex == FragquestionBank.lastIndex) {}
        else currentIndex = currentIndex + 1

        // val questionTextResId = questionBank[currentIndex].textResId
        val questionTextResId = fragcurrentQuestionText
        questionTextView?.setText(questionTextResId)
    }
}