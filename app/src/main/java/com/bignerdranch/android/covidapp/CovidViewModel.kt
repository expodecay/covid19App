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
        Questions(R.string.question_asthma, 2),
        Questions(R.string.question_cardiovascular, 2),
        Questions(R.string.question_lung, 2),
        Questions(R.string.question_immune, 2),
        Questions(R.string.question_metabolic, 2),
        Questions(R.string.question_neurologic, 2),
        Questions(R.string.question_other, 2),
        Questions(R.string.question_autoimmune, 2),
        Questions(R.string.question_obesity, 2),
        Questions(R.string.question_pregnancy, 2),
        Questions(R.string.question_renal, 2),
        Questions(R.string.question_liver, 2),
        Questions(R.string.question_hypertension, 2)
    )

    val currentQuestionAnswer: Int
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
