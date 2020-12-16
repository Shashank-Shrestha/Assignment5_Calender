package com.example.assignment5_calender

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.time.LocalDate
import java.util.*

class assignment5CalenderActivity : AppCompatActivity() {
    private lateinit var etJoinDate: EditText
    private lateinit var etDOB: EditText
    private lateinit var tvYears: TextView
    private lateinit var tvJoin: TextView
    private lateinit var tvDOB: TextView
    private lateinit var tvBirth: TextView

   private val c = Calendar.getInstance()
    private val year =c.get(Calendar.YEAR)
    private val month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment5_calender)

        etJoinDate=findViewById(R.id.etJoinDate)
        etDOB=findViewById(R.id.etDOB)
        tvYears=findViewById(R.id.tvYears)
        tvJoin=findViewById(R.id.tvJoin)
        tvDOB=findViewById(R.id.tvDOB)
        tvBirth=findViewById(R.id.tvBirth)

        etJoinDate.setOnClickListener {
            dateofJoin()
            tvYears.visibility = View.VISIBLE
        }

        etDOB.setOnClickListener {
            age()
            tvDOB.visibility = View.VISIBLE
        }

    }

    private fun dateofJoin(){

        val datePickerDialog = DatePickerDialog(this, { view, yearNew, monthOfYear, dayOfMonth ->
            etJoinDate.setText("$dayOfMonth/${monthOfYear + 1}/$yearNew")
            if (month-monthOfYear<0){
                var diffYear = (year - yearNew)-1
                var diffMonth = (month - monthOfYear) + 12
                if (diffYear == 0){
                    tvJoin.text = "$diffMonth Months"
                }
                else if (diffMonth == 0){
                    tvJoin.text = "$diffYear years"
                }
                else{
                    tvJoin.text = "$diffYear Years & $diffMonth Months"
                }
            }else{
                var diffYear = year - yearNew
                var diffMonth =month - monthOfYear
                if (diffYear == 0){
                    tvJoin.text = "$diffMonth Months"
                }
                else if (diffMonth == 0){
                    tvJoin.text = "$diffYear years"
                }
                else{
                    tvJoin.text = "$diffYear Years & $diffMonth Months"
                }
            }
        },
        year,month,day
        )
        datePickerDialog.show()
        }

    private fun age(){

        val datePickerDialog = DatePickerDialog(this, { view, yearNew, monthOfYear, dayOfMonth ->
            etDOB.setText("$dayOfMonth/${monthOfYear + 1}/$yearNew")
                var age = year - yearNew
            tvBirth.text = "$age"

        },
                year,month,day
        )
        datePickerDialog.show()
    }




}
