package com.example.thali.myproject1404

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

/**
 * Created by thali on 14/04/2018.
 */
class TwoActivity : AppCompatActivity() {

    private val TVWelcome by lazy { findViewById<TextView>(R.id.TVWelcome) }

    private val name by lazy { intent.getStringExtra("username") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        TVWelcome.setText(name + ",Welcome to Activity TWO")




    }
}