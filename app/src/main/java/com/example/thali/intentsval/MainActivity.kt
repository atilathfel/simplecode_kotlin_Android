package com.example.thali.intentsval

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.thali.myproject1404.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        private const val THIRD_ACTIVITY : Int = 3

    }

    private val etNome by lazy { findViewById<EditText>(R.id.ETNome) }
    private val btnActivityTwo  by lazy { findViewById<Button>(R.id.btnActivityTwo) }
    private val btnActivityThree  by lazy { findViewById<Button>(R.id.btnActivityThree) }
    private val TVdataHere  by lazy { findViewById<TextView>(R.id.TVDataHere) }

    private val btnClear by lazy { findViewById<Button>(R.id.btnClear) }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnActivityTwo.setOnClickListener {
            val nome: String = etNome.text.toString().trim()

            if (!TextUtils.isEmpty(ETNome.text.toString().trim()) ) {


                val intentTwo = Intent(this@MainActivity, TwoActivity::class.java)
                intentTwo.putExtra("nome", nome)
                startActivity(intentTwo)
            }else{
                Toast.makeText(this,"Por favor, Digite Seu Nome!!!",Toast.LENGTH_LONG).show()
            }
        }

        btnActivityThree.setOnClickListener {
            if (!TextUtils.isEmpty(ETNome.text.toString().trim())) {

                val intentThree = Intent(this@MainActivity, ThreeActivity::class.java)
                startActivityForResult(intentThree, THIRD_ACTIVITY)
            }else{
                Toast.makeText(this,"Por favor, Primeiramente Digite Seu Nome",Toast.LENGTH_LONG).show()
            }
        }

        btnClear.setOnClickListener {
            ETNome.setText("")
            TVDataHere.setText("")

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val sobrenome : String
        val nome : String

        if (requestCode == THIRD_ACTIVITY && resultCode == Activity.RESULT_OK) {
            sobrenome = data!!.getStringExtra("sobrenome")
            nome = etNome.text.toString().trim()
            TVdataHere.setText(nome + " " + sobrenome)


        }


    }


}
