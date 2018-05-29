package com.yotharit.helloworld

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView
    lateinit var secondButton: Button
    lateinit var secondEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)
//        finish()

//        initInstance()
//        var bundle = intent.extras.getBundle("cBundle")
//        var cSerial : CoordinateSerializable = intent.getSerializableExtra("coordinateSerializable") as CoordinateSerializable

//        var coordinateParcelazble : CoordinateParcelazble = intent.getParcelableExtra("coPar")
//        resultTextView.text = "Result = " + sum



    }

    fun initInstance(){
        resultTextView = findViewById(R.id.tvREEEEE)
        secondButton = findViewById(R.id.buttonExtra)
        secondEditText = findViewById(R.id.secondEditText)
        secondButton.setOnClickListener(object : View.OnClickListener   {
            override fun onClick(v: View?) {
                var intent : Intent = Intent()
                intent.putExtra("result",secondEditText.text.toString())
                setResult(Activity.RESULT_OK,intent)
                finish()
            }

        })
    }
}
