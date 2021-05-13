package com.bignerdranch.android.covidapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.covidapp.model.Post
import com.bignerdranch.android.covidapp.repository.Repository


/**
 * A simple [Fragment] subclass.
 * Use the [ResponseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResponseFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_response, container, false)

        val one = view.findViewById<TextView>(R.id.sex)
        val two = view.findViewById<TextView>(R.id.patient_type)
        val three = view.findViewById<TextView>(R.id.intubed)
        val four = view.findViewById<TextView>(R.id.pneumonia)
        val five = view.findViewById<TextView>(R.id.age)
        val six = view.findViewById<TextView>(R.id.pregnancy)
        val seven = view.findViewById<TextView>(R.id.diabetes)
        val eight = view.findViewById<TextView>(R.id.copd)
        val nine = view.findViewById<TextView>(R.id.asthma)
        val ten = view.findViewById<TextView>(R.id.inmsupr)
        val eleven = view.findViewById<TextView>(R.id.hypertension)
        val twelve = view.findViewById<TextView>(R.id.other_disease)
        val thirteen = view.findViewById<TextView>(R.id.cardiovascular)
        val fourteen = view.findViewById<TextView>(R.id.obesity)
        val fifteen = view.findViewById<TextView>(R.id.renal_chronic)
        val sixteen = view.findViewById<TextView>(R.id.tobacco)
        val seventeen = view.findViewById<TextView>(R.id.contact_other_covid)
        val eighteen = view.findViewById<TextView>(R.id.icu)
        one.setText("sex: " + Patient.sex.toString())
        two.setText("patient_type: " + Patient.patient_type.toString())
        three.setText("intubed: " +Patient.intubed.toString())
        four.setText("pneumonia: " + Patient.pneumonia.toString())
        five.setText("age: " +Patient.age.toString())
        six.setText("pregnancy: " +Patient.pregnancy.toString())
        seven.setText("diabetes: " +Patient.diabetes.toString())
        eight.setText("copd: " +Patient.copd.toString())
        nine.setText("asthma: " +Patient.asthma.toString())
        ten.setText("inmsupr: " +Patient.inmsupr.toString())
        eleven.setText("hypertension: " +Patient.hypertension.toString())
        twelve.setText("other_disease: " +Patient.other_disease.toString())
        thirteen.setText("cardiovascular: " +Patient.cardiovascular.toString())
        fourteen.setText("obesity: " +Patient.obesity.toString())
        fifteen.setText("renal_chronic: " +Patient.renal_chronic.toString())
        sixteen.setText("tobacco: " +Patient.tobacco.toString())
        seventeen.setText("contact_other_covid: " +Patient.contact_other_covid.toString())
        eighteen.setText("icu: " +Patient.icu.toString())

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeButton = view?.findViewById<Button>(R.id.home_btn) as TextView
        val output     = view?.findViewById<TextView>(R.id.out)
        val outputcode = view?.findViewById<TextView>(R.id.code)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val myPost = Post(  Patient.get_sex(), Patient.get_patient_type(),
            Patient.get_intubed(), Patient.get_pneumonia(), Patient.get_age(), Patient.get_pregnancy(),
            Patient.get_diabetes(), Patient.get_copd(), Patient.get_Asthma(), Patient.get_inmsupr(),
            Patient.get_hypertension(), Patient.get_other_disease(), Patient.get_cardiovascular(),
            Patient.get_Obesity(), Patient.get_renal_chronic(), Patient.get_tobacco(),
            Patient.get_contact_other_covid(), Patient.get_icu() )

        viewModel.AWS(myPost)
        //viewModel.getPost()
        viewModel.AWSResponse.observe(viewLifecycleOwner, Observer{response ->
            if(response.isSuccessful){
                Log.d("Main: ", response.body().toString())
                // 201: request success -> resource created
                // 200: everything OK
                Log.d("Main: ", response.toString())
                Log.d("Main: ", response.message())

                if(response.body().toString()=="0") {
                    output.text = response.body().toString() + ":  Hospitalization Not Likely"
                    outputcode.text = response.toString()
                }else{
                    output.text = response.body().toString() + ":  Hospitalization Likely"
                    outputcode.text = response.toString()
                }

            }else{
                Log.d("Error response", response.errorBody().toString())
            }
        })

        homeButton.setOnClickListener {
            // get the fragment instance
            val nextFragment = AgeFragment()
            // get the support fragment manager instance
            val manager = (context as MainActivity).supportFragmentManager
            // begin fragment transaction using fragment manager
            val transaction = manager.beginTransaction()
            // replace fragment in the container and finish the transaction
            transaction.replace(R.id.frameLayout, nextFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            // reset patient values
            Patient.sex = 0
            Patient.patient_type = 1
            Patient.intubed = 2
            Patient.pneumonia = 2
            Patient.age = 15
            Patient.pregnancy = 2
            Patient.diabetes = 2
            Patient.copd = 2
            Patient.asthma = 2
            Patient.inmsupr = 2
            Patient.hypertension = 2
            Patient.other_disease = 2
            Patient.cardiovascular = 2
            Patient.obesity = 2
            Patient.renal_chronic = 2
            Patient.tobacco = 2
            Patient.contact_other_covid = 2
            Patient.icu = 2
        }

        /*
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer{response ->
            if(response.isSuccessful){
                Log.d("sex Response", response.body()?.sex.toString())
                Log.d("patient_type Response", response.body()?.patient_type.toString())
                Log.d("intubed Response", response.body()?.intubed.toString())
                Log.d("pneumonia Response", response.body()?.pneumonia.toString())
                Log.d("age Response", response.body()?.age.toString())
                Log.d("pregnancy Response", response.body()?.pregnancy.toString())
                Log.d("diabetes Response", response.body()?.diabetes.toString())
                Log.d("copd Response", response.body()?.copd.toString())
                Log.d("asthma Response", response.body()?.asthma.toString())
                Log.d("inmsupr Response", response.body()?.inmsupr.toString())
                Log.d("hypertension Response", response.body()?.hypertension.toString())
                Log.d("other_disease Response", response.body()?.other_disease.toString())
                Log.d("cardiovascular Response", response.body()?.cardiovascular.toString())
                Log.d("obesity Response", response.body()?.obesity.toString())
                Log.d("renal_chronic Response", response.body()?.renal_chronic.toString())
                Log.d("tobacco Response", response.body()?.tobacco.toString())
                Log.d("contact_other", response.body()?.contact_other_covid.toString())
                Log.d("icu Response", response.body()?.icu.toString())

            }else{
                Log.d("Error response", response.errorBody().toString())
            }
        })

         */
    }

}