package com.example.caculatethetip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        caculate_button.setOnClickListener {
            caculate()
        }
    }
        fun caculate(){
            val cost  = cost_tip.text.toString().toDoubleOrNull()
            if (cost==null){
                result_text.text = ""
               return
            }
            val selected_id = tip_option.checkedRadioButtonId
            val tip_percent = when(selected_id){
                R.id.radioButton_5percent -> 0.05
                R.id.radioButton_10percent -> 0.1
                else ->0.15
            }
            var tip = tip_percent * cost
            val round_up = switch_roundtip.isChecked
            if (round_up){
                val result = ceil(tip)
                result_text.text = getString(R.string.tip_amount,result)
            } else
            {
                result_text.text = getString(R.string.tip_amount,tip)
            }
        }

}