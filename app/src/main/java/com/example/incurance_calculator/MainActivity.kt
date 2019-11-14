package com.example.incurance_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this,"Item = ${spinnerAge.getItemAtPosition(p2)}",Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinnerAge.onItemSelectedListener = this

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }
    }
    private fun calculatePremium(){
        //TODO calculate insurance premium
        var premium : Int = 0
        //var epm : Int = 0
        //posiotion = index of an item selected by user
        val age: Int = spinnerAge.selectedItemPosition
         premium = when(age){
             0 -> 60
             1 -> 70
             2 -> 90
             3 -> 120
             else -> 150
         }
        // ID of a radioButton checked by user
        val gender: Int = radioGroupGender.checkedRadioButtonId
        if(gender == R.id.radioButtonMale)
        {
            premium += when(age)
            {
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                else -> 200
            }
        }
        val smoker: Boolean = checkBoxSmoker.isChecked
        if(smoker)
        {
            premium += when(age)
            {
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                else -> 300
            }
        }
        textViewPremium.text =getString(R.string.premium) + premium.toString()
    }

    fun resetInput(view: View?){
        //TODO clear all inputs and outputs
        radioGroupGender.clearCheck()
        checkBoxSmoker.setChecked(false)
        textViewPremium.text =""
        spinnerAge.setSelection(0)
    }
}
