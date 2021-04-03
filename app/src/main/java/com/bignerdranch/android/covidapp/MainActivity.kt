package com.bignerdranch.android.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button;
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"
private const val KEY_INDEX = "index"
class MainActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_main) // gives the activity it's UI to manage (it inflates a layout)


    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, covidViewModel.currentIndex)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
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
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}