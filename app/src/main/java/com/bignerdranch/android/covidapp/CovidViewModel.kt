package com.bignerdranch.android.covidapp

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "CovidViewModel"
class CovidViewModel : ViewModel() {
    var currentIndex = 0
    private val questionBank = listOf(
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

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        if(currentIndex == questionBank.lastIndex){
            currentIndex = questionBank.lastIndex
            //
            // Need to transition to confirmation and transfer module
        }
        else {
            currentIndex = currentIndex + 1
        }
    }
}
