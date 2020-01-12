package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calendar = Calendar.getInstance()
        val today = Calendar.getInstance()

        val datePicker = object : DatePickerDialog.OnDateSetListener{

            override fun onDateSet(view : DatePicker, year : Int, month: Int, day: Int){

                calendar.set(year,month,day)
                val dateFormat = "dd/MM.yyyy"
                val sDateFormat = SimpleDateFormat(dateFormat,Locale.US)
                var saving = 0

                val age = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)

                Age.setText("Age:" + age.toString())

                if(age in 16..20){
                    saving = 5000
                }else if(age in 21..25){
                    saving = 14000
                }else if(age in 26..30) {
                    saving = 29000
                }else if(age in 31..35) {
                    saving = 50000
                }else if(age in 36..40){
                    saving = 78000
                }else if(age in 41..45) {
                    saving = 116000
                }else if(age in 46..50) {
                    saving = 165000
                }else if (age in 51..55) {
                    saving = 228000
                }else{
                    saving = 0
                }

                Saving.text = "Min. Savings:" + saving.toString()

                }
        }

        dateButton.setOnClickListener{

            val datePickerDialog = DatePickerDialog(this,datePicker,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}
