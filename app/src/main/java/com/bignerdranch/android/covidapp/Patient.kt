package com.bignerdranch.android.covidapp

import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import com.google.gson.annotations.Expose
import com.bignerdranch.android.covidapp.api.WebServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Patient {
/*
    companion object {
        private var instance: Patient? = null
        operator fun invoke() = synchronized(this){
            if (instance == null)
                instance = Patient()
            instance
        }
    }
}
fun main() {
    Patient() // same as writing Patient.invoke()
}

*/
    var sex:Int             = 2
    var patient_type:Int    = 1
    var intubed:Int         = 2
    var pneumonia:Int       = 2
    var age:Int             = 15
    var pregnancy :Int      = 2
    var diabetes:Int        = 2
    var copd:Int            = 2
    var asthma:Int          = 2
    var inmsupr:Int         = 2
    var hypertension:Int    = 2
    var other_disease:Int   = 2
    var cardiovascular:Int  = 2
    var obesity:Int         = 2
    var renal_chronic:Int   = 2
    var tobacco:Int         = 2
    var contact_other_covid = 2
    var icu                 = 2





    //getter functions --------------------------------------------------------------------------------
    fun get_patient_type() : Int{
        return patient_type
    }
    fun get_intubed() : Int{
        return intubed
    }

    fun get_age() : Int{
        return age
    }

    fun get_pneumonia() : Int{
        return pneumonia
    }

    fun get_sex() : Int{
        return sex
    }

    fun get_Asthma() : Int{
        return asthma
    }

    fun get_diabetes() : Int{
        return diabetes
    }

    fun get_copd() : Int{
        return copd
    }

    fun get_cardiovascular() : Int{
        return cardiovascular
    }

    fun get_inmsupr() : Int{
        return inmsupr
    }

    fun get_tobacco() : Int{
        return tobacco
    }

    fun get_contact_other_covid() : Int{
        return contact_other_covid
    }

    fun get_icu() : Int{
        return icu
    }

    fun get_other_disease() : Int{
        return other_disease
    }

    fun get_Obesity() : Int{
        return obesity
    }

    fun get_pregnancy() : Int{
        return pregnancy
    }

    fun get_renal_chronic() : Int{
        return renal_chronic
    }



    fun get_hypertension() : Int{
        return hypertension
    }

//end of getter functions---------------------------------------------------------------------------

}//end of patient class