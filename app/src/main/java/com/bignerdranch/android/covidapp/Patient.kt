package com.bignerdranch.android.covidapp

//need to now about the variables used by webservice team to create proper attributes.

class Patient(val id:Int,val age:Int, val sex:Char,
val Ethnicity: String, val Asthma : Boolean ){

 //getter functions --------------------------------------------------------------------------------
    fun get_age() : Int{
    return age
    }

    fun get_sex() : Char{
        return sex
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
//end of getter functions---------------------------------------------------------------------------


}//end of patient class