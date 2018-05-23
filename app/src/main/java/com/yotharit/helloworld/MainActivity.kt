package com.yotharit.helloworld

import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Display
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvAnswer: TextView
    lateinit var editTextFirst: EditText
    lateinit var editTextSecond: EditText
    lateinit var btnCalculate: Button
    lateinit var radioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)
//        initInstance()
        val display : Display = windowManager.defaultDisplay
        val size : Point = Point(0,0)
        display.getSize(size)
        val width = size.x
        val height = size.y
        Toast.makeText(this,"Width : "+width+" Height : "+height,Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_settings) {
            //do something
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initInstance() {
        tvAnswer = findViewById(R.id.tvAnswer)
        editTextFirst = findViewById(R.id.editTextFirst)
        editTextSecond = findViewById(R.id.editTextSecond)
        btnCalculate = findViewById(R.id.btnCalculate)
        btnCalculate.setOnClickListener(this)
        radioGroup = findViewById(R.id.rbGroup)

    }

    override fun onClick(v: View?) {
        if (v == btnCalculate) calculate()
    }

    private fun calculate() {
        if (editTextFirst.text != null && editTextSecond.text != null) {
            var answer: Double = 0.0
            val firstDigit: Double = editTextFirst.text.toString().toDouble()
            val secondDigit: Double = editTextSecond.text.toString().toDouble()
            when (rbGroup.checkedRadioButtonId) {
                R.id.rbAdd -> answer = firstDigit + secondDigit
                R.id.rbMinus -> answer = firstDigit - secondDigit
                R.id.rbMultiply -> answer = firstDigit * secondDigit
                R.id.rbDivide -> answer = firstDigit / secondDigit
            }
            tvAnswer.setText("=" + answer)
            Log.d("Calculation", answer.toString())
            Toast.makeText(this, "Calculation : " + answer, Toast.LENGTH_SHORT).show()
        }

    }


}
