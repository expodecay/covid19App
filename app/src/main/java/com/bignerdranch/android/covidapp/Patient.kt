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

private const val TAG = "PATIENT"

val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("?")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val webServiceApi: WebServiceApi = retrofit.create(WebServiceApi::class.java)

//need to know about the variables used by webservice team to create proper attributes.

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
    @Expose
    var id:Int = 0
    @Expose
    var age :String = ""
    @Expose
    var sex: String = ""
    @Expose
    var ethnicity: String = ""
    @Expose
    var asthma : Boolean = false
    @Expose
    var cardio : Boolean = false
    @Expose
    var lung: Boolean = false
    @Expose
    var immune: Boolean = false
    @Expose
    var metaba : Boolean = false
    @Expose
    var neuro : Boolean = false
    @Expose
    var other : Boolean = false
    @Expose
    var obesity : Boolean = false
    @Expose
    var pregnant : Boolean = false
    @Expose
    var renal : Boolean = false
    @Expose
    var gastro: Boolean = false
    @Expose
    var hyper : Boolean = false
    @Expose
    var auto: Boolean = false


    //getter functions --------------------------------------------------------------------------------
    fun get_age() : String{
    return age
    }

    fun get_sex() : String{
        return sex
    }

    fun get_id() : Int{
        return id
    }

    fun get_Ethnicity() : String{
        return ethnicity
    }

    fun get_Asthma() : Boolean{
        return asthma
    }

    fun get_Cardio() : Boolean{
        return cardio
    }

    fun get_Lung() : Boolean{
        return lung
    }

    fun get_Immune() : Boolean{
        return immune
    }

    fun get_Metaba() : Boolean{
        return metaba
    }

    fun get_Neuro() : Boolean{
        return neuro
    }

    fun get_Other() : Boolean{
        return other
    }

    fun get_Obesity() : Boolean{
        return obesity
    }

    fun get_Pregnant() : Boolean{
        return pregnant
    }

    fun get_Renal() : Boolean{
        return renal
    }

    fun get_Gastro() : Boolean{
        return gastro
    }

    fun get_Hyper() : Boolean{
        return hyper
    }
    fun get_Autoimmune() : Boolean{
        return auto
    }
//end of getter functions---------------------------------------------------------------------------

    fun sendForm() {
        webServiceApi.sendPatientForm(this).enqueue(object : Callback<Patient?> {
            override fun onResponse(call: Call<Patient?>?, response: Response<Patient?>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "post submitted to API." + response.body().toString())
                }
            }

            override fun onFailure(call: Call<Patient?>?, t: Throwable?) {
                Log.e(TAG, "Unable to submit post to API.")
            }
        })
    }

}//end of patient class