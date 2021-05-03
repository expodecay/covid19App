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
    var age: Int = 2
    @Expose
    var sex: Int = 2
    @Expose
    var ethnicity: Int = 2
    @Expose
    var asthma : Int = 2
    @Expose
    var cardio : Int = 2
    @Expose
    var lung: Int = 2
    @Expose
    var immune: Int = 2
    @Expose
    var metaba : Int = 2
    @Expose
    var neuro : Int = 2
    @Expose
    var other : Int = 2
    @Expose
    var obesity : Int = 2
    @Expose
    var pregnant : Int = 2
    @Expose
    var renal : Int = 2
    @Expose
    var gastro: Int = 2
    @Expose
    var hyper : Int = 2
    @Expose
    var auto: Int = 2


    //getter functions --------------------------------------------------------------------------------
    fun get_age() : Int{
    return age
    }

    fun get_sex() : Int{
        return sex
    }

    fun get_id() : Int{
        return id
    }

    fun get_Ethnicity() : Int{
        return ethnicity
    }

    fun get_Asthma() : Int{
        return asthma
    }

    fun get_Cardio() : Int{
        return cardio
    }

    fun get_Lung() : Int{
        return lung
    }

    fun get_Immune() : Int{
        return immune
    }

    fun get_Metaba() : Int{
        return metaba
    }

    fun get_Neuro() : Int{
        return neuro
    }

    fun get_Other() : Int{
        return other
    }

    fun get_Obesity() : Int{
        return obesity
    }

    fun get_Pregnant() : Int{
        return pregnant
    }

    fun get_Renal() : Int{
        return renal
    }

    fun get_Gastro() : Int{
        return gastro
    }

    fun get_Hyper() : Int{
        return hyper
    }
    fun get_Autoimmune() : Int{
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