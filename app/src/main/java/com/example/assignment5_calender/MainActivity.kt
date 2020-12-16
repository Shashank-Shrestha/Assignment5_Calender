
package com.example.assignment5_calender

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var etJoinDate:EditText
    private lateinit var etDOB: EditText
    private lateinit var tvYears: TextView
    private lateinit var tvJoin: TextView
    private lateinit var tvDOB: TextView
    private lateinit var tvBirth: TextView
    val c = Calendar.getInstance()
    val year =c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etJoinDate=findViewById(R.id.etJoinDate)
        etDOB=findViewById(R.id.etDOB)
        tvYears=findViewById(R.id.tvYears)
        tvJoin=findViewById(R.id.tvJoin)
        tvDOB=findViewById(R.id.tvDOB)
        tvBirth=findViewById(R.id.tvBirth)


        etJoinDate.setOnClickListener {
            JoinCalender()
            tvYears.visibility = View.VISIBLE
        }

//        etDOB.setOnClickListener {
//           BirthCalender()
//        }

//        etJoinDate.setOnFocusChangeListener {v,hasFocus ->
//           if (hasFocus)
//               JoinCalender()
//        }

        etDOB.setOnClickListener {
                BirthCalender()
            tvDOB.visibility=View.VISIBLE
        }

    }

    private fun JoinCalender(){
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
               etJoinDate.setText("$dayOfMonth/${month+1}/$year")
                tvJoin.text="$month"
                val currentDate=LocalDate.now()
                val curYearWork=currentDate.year
                val curMonthWork=currentDate.month
                val workYear=(curYearWork-year)
                val workMonth=(curMonthWork-month.toLong())
                tvJoin.text="$workYear  ${workMonth.toString()} "
            },
            year,
            month,
            day,
        )
        datePickerDialog.show()
        etJoinDate.clearFocus()
    }

    private fun BirthCalender(){
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                etDOB.setText("$dayOfMonth/${month + 1}/$year")
                val current=LocalDate.now()
                val curyear=current.year
                val age=(curyear-year)
                tvBirth.text=age.toString()
            },
            year-20,
            month,
            day
        )
        datePickerDialog.show()


    }
}