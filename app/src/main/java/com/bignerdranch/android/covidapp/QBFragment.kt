package com.bignerdranch.android.covidapp

import android.os.Bundle
import android.util.Log
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
private const val KEY_INDEX = "index"
private const val TAG = "Question Bank Fragment"
class QBFragment : Fragment() {
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val covidViewModel: CovidViewModel by lazy{
        ViewModelProviders.of(this).get(CovidViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // called when an instance of an activity is created
        Log.d(TAG, "onCreate(Bundle?) called")
        (context as MainActivity).setContentView(R.layout.activity_main) // gives the activity it's UI to manage (it inflates a layout)

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        covidViewModel.currentIndex = currentIndex

        yesButton = (context as MainActivity).findViewById(R.id.yes_button)
        noButton = (context as MainActivity).findViewById(R.id.no_button)
        nextButton = (context as MainActivity).findViewById(R.id.next_button)
        questionTextView = (context as MainActivity).findViewById(R.id.question_text_view)

        yesButton.setOnClickListener{ view: View ->  // listener set to inform when button is pressed
            // Do something in response to the click here
            checkAnswers(true)
        }

        noButton.setOnClickListener { view: View ->
            // Do something in response to the click here
            checkAnswers(false)
        }

        nextButton.setOnClickListener {
            // currentIndex=(currentIndex + 1 ) % questionBank.size
            covidViewModel.moveToNext()
            updateQuestion()
        }
        updateQuestion()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q_b, container, false)
    }
    private fun updateQuestion(){
        // val questionTextResId = questionBank[currentIndex].textResId
        val questionTextResId = covidViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }
    //
    // Needs to become storeAnswer to patient class
    private fun checkAnswers(userAnswer: Boolean){
        // val correctAnswer = questionBank[currentIndex].answer
        val correctAnswer = covidViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
       // Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

}