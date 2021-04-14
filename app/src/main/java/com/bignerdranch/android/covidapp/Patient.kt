package com.bignerdranch.android.covidapp

import android.widget.Button
import androidx.lifecycle.ViewModel

//need to now about the variables used by webservice team to create proper attributes.

object Patient {
    init { }



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
var id:Int = 0
    var Age:String = ""
    var Sex: String = ""
    var Ethnicity: String = ""
    var Asthma : Boolean = false
    var Cardio : Boolean = false
    var Lung : Boolean = false
    var Immune : Boolean = false
    var Metaba : Boolean = false
    var Neuro : Boolean = false
    var Other : Boolean = false
    var Obesity : Boolean = false
    var Pregnant : Boolean = false
    var Renal : Boolean = false
    var Gastro : Boolean = false
    var Hyper : Boolean = false
    var Auto: Boolean = false


    //getter functions --------------------------------------------------------------------------------
    fun get_age() : String{
    return Age
    }

    fun get_sex() : String{
        return Sex
    }

    fun get_id() : Int{
        return id
    }

    fun get_Ethnicity() : String{
        return Ethnicity
    }

    fun get_Asthma() : Boolean{
        return Asthma
    }

    fun get_Cardio() : Boolean{
        return Cardio
    }

    fun get_Lung() : Boolean{
        return Lung
    }

    fun get_Immune() : Boolean{
        return Immune
    }

    fun get_Metaba() : Boolean{
        return Metaba
    }

    fun get_Neuro() : Boolean{
        return Neuro
    }

    fun get_Other() : Boolean{
        return Other
    }

    fun get_Obesity() : Boolean{
        return Obesity
    }

    fun get_Pregnant() : Boolean{
        return Pregnant
    }

    fun get_Renal() : Boolean{
        return Renal
    }

    fun get_Gastro() : Boolean{
        return Gastro
    }

    fun get_Hyper() : Boolean{
        return Hyper
    }
    fun get_Autoimmune() : Boolean{
        return Auto
    }
//end of getter functions---------------------------------------------------------------------------

}//end of patient class