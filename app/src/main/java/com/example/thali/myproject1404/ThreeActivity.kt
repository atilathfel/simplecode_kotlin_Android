package com.example.thali.myproject1404

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

class ThreeActivity : AppCompatActivity() , View.OnClickListener{

    private val ETSurname by lazy { findViewById<EditText>(R.id.ETSurname) }
    private val btnSubmit by lazy { findViewById<Button>(R.id.BtnSubmit) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        btnSubmit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var surname : String = ETSurname.text.toString().trim()

        var intentThree = Intent()
        intentThree.putExtra("surname",surname)
        setResult(RESULT_OK,intentThree)

        finish()
    }
}
