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
    var currentIndex = 0
    private val FragquestionBank = listOf(
        // Questions(R.string.question_age, false),
        // Questions(R.string.question_gender, false),
        // Questions(R.string.question_ethnicity, false),
        Questions(R.string.question_asthma, false),
        Questions(R.string.question_cardiovascular, false),
        Questions(R.string.question_lung, false),
        Questions(R.string.question_immune, false),
        Questions(R.string.question_metabolic, false),
        Questions(R.string.question_neurologic, false),
        Questions(R.string.question_other, false),
        Questions(R.string.question_autoimmune, false),
        Questions(R.string.question_obesity, false),
        Questions(R.string.question_pregnancy, false),
        Questions(R.string.question_renal, false),
        Questions(R.string.question_liver, false),
        Questions(R.string.question_hypertension, false)
    )
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

    private val covidViewModel: CovidViewModel by lazy{
        ViewModelProviders.of(this).get(CovidViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_q_b, container, false)

        val Button = view?.findViewById<Button>(R.id.qb_next_button) as TextView
        Button.setOnClickListener {
            val testText = view?.findViewById<TextView>(R.id.question_text_view)
            testText.text="${FragquestionBank[currentIndex]}"
            fragmoveToNext()
            updateQuestion()
        }
        // Inflate the layout for this fragment
        return view
    }

     fun updateQuestion(){
        // val questionTextResId = questionBank[currentIndex].textResId
        val questionTextResId = fragcurrentQuestionText
         questionTextView?.setText(questionTextResId)
    }
     fun setAnswers(userAnswer: Boolean){
        //send answers to patient class
    }
}