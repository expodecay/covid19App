package com.bignerdranch.android.covidapp

import androidx.annotation.StringRes
/*
class Questions {
}
*/

data class Questions(@StringRes val textResId: Int, var answer: Boolean)