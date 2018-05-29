package com.yotharit.helloworld

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Point
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Display
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.io.Serializable

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvAnswer: TextView
    lateinit var editTextFirst: EditText
    lateinit var editTextSecond: EditText
    lateinit var btnCalculate: Button
    lateinit var radioGroup: RadioGroup
    lateinit var customViewGroup1: CustomViewGroup
    lateinit var customViewGroup2: CustomViewGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(resources.getBoolean(R.bool.portrait_only)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        setContentView(R.layout.activity_main)

        initInstance()


        val display: Display = windowManager.defaultDisplay
        val size: Point = Point(0, 0)
        display.getSize(size)
        val width = size.x
        val height = size.y
        Toast.makeText(this, "Width : " + width + " Height : " + height, Toast.LENGTH_LONG).show()



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
        customViewGroup1 = findViewById(R.id.ViewGroup1)
        customViewGroup2 = findViewById(R.id.ViewGroup2)

        customViewGroup1.setButtonText("Hello")
        customViewGroup2.setButtonText("World!")
    }

    override fun onClick(v: View?) {
        if (v == btnCalculate) calculate()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //save things
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 12345) {
            if(resultCode == Activity.RESULT_OK) {
                Toast.makeText(this,data!!.getStringExtra("result"),Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun calculate() {
        if (!editTextFirst.text.toString().equals("") && !editTextSecond.text.toString().equals("")) {
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
//            Toast.makeText(this, "Calculation : " + answer, Toast.LENGTH_SHORT).show()
            var intent: Intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("result", answer)

//            var coordinate1: Coordinate = Coordinate()
//            coordinate1.x = 5
//            coordinate1.y = 10
//            coordinate1.z = 20
//            var bundle: Bundle = Bundle()
//            bundle.putInt("x", coordinate1.x)
//            bundle.putInt("y", coordinate1.y)
//            bundle.putInt("z", coordinate1.z)
//            intent.putExtra("cBundle", bundle)
//            var coordinate2: CoordinateSerializable = CoordinateSerializable()
//            coordinate2.x = 10
//            coordinate2.y = 20
//            coordinate2.z = 30
//            intent.putExtra("coordinateSerializable", coordinate2)
//            var coordinate3: CoordinateParcelazble = CoordinateParcelazble()
//            coordinate3.x = 50
//            coordinate3.y = 60
//            coordinate3.z = 70
//            intent.putExtra("coPar", coordinate3)

            startActivityForResult(intent,12345)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }

    }


}
