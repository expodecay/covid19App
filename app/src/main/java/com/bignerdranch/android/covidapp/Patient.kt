package com.bignerdranch.android.covidapp

class Patient(val id:Int,val age:Int, val sex:Char){

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
//end of getter functions---------------------------------------------------------------------------


}//end of patient class