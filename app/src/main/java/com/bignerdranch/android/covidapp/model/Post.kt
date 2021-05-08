package com.bignerdranch.android.covidapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post (


      // @SerializedName("Deceased") val Deceased:Number,

        val sex:Int,
        val patient_type:Int,
        val intubed:Int,
        val pneumonia:Int,
        val age:Int,
        val pregnancy:Int,
        val diabetes:Int,
        val copd:Int,
        val asthma:Int,
        val inmsupr:Int,
        val hypertension:Int,
        val other_disease:Int,
        val cardiovascular:Int,
        val obesity:Int,
        val renal_chronic:Int,
        val tobacco:Int,
        val contact_other_covid:Int,
        val icu:Int
)
