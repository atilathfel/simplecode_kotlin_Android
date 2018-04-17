package com.example.thali.intentsval

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.thali.myproject1404.R


class TwoActivity : AppCompatActivity() {

    private val TVBemVindo by lazy { findViewById<TextView>(R.id.TVBemVindo) }

    private val editNome by lazy { intent.getStringExtra("nome") }

    private val btnVoltar by lazy { findViewById<Button>(R.id.BtnVoltar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        TVBemVindo.setText( getString(R.string.bem_vindo) + editNome)


        btnVoltar.setOnClickListener {
            finish()

        }



    }




}