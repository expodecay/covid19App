package com.bignerdranch.android.covidapp

import androidx.annotation.StringRes

data class Questions(@StringRes val textResId: Int, var answer: Boolean)