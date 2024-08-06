package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivision: Button
    lateinit var etA: EditText
    lateinit var etB: EditText
    lateinit var resulty: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_subtraction)
        btnMultiply = findViewById(R.id.btn_multiplication)
        btnDivision = findViewById(R.id.btn_division)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resulty = findViewById(R.id.result_tv)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val a = etA.text.toString().toDoubleOrNull()
        val b = etB.text.toString().toDoubleOrNull()

        if (a == null || b == null) {
            resulty.text = "Please enter valid numbers"
            return
        }

        var result = 0.0
        when (v?.id) {
            R.id.btn_add -> {
                result = a + b
            }

            R.id.btn_subtraction -> {
                result = a - b
            }

            R.id.btn_multiplication -> {
                result = a * b
            }

            R.id.btn_division -> {
                if (b != 0.0) {
                    result = a / b
                } else {
                    resulty.text = "Cannot divide by zero"
                    return
                }
            }
        }
        resulty.text = "Resultado é $result"
    }
}
