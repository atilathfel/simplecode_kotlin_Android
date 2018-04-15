package com.example.thali.myproject1404

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        private const val ACTIVITY3 : Int = 3

    }

    private val etName  by lazy { findViewById<EditText>(R.id.ETName) }
    private val btnActivityTwo  by lazy { findViewById<Button>(R.id.btnActivityTwo) }
    private val btnActivityThree  by lazy { findViewById<Button>(R.id.btnActivityThree) }
    private val TVDataHere  by lazy { findViewById<TextView>(R.id.TVDataHere) }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnActivityTwo.setOnClickListener {
            //Toast.makeText(this@MainActivity,"Clicou Activity2",Toast.LENGTH_LONG).show()

            var name : String = ETName.text.toString().trim()

            var intentTwo =  Intent(this@MainActivity,TwoActivity::class.java)
            intentTwo.putExtra("username",name)
            startActivity(intentTwo)
        }

        btnActivityThree.setOnClickListener {
            //Toast.makeText(this@MainActivity,"Clicou Activity 3",Toast.LENGTH_LONG).show()
            var intentThree = Intent(this@MainActivity,ThreeActivity::class.java)
            startActivityForResult(intentThree,ACTIVITY3)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var surname : String
        var name : String

        if (requestCode == ACTIVITY3 && resultCode == Activity.RESULT_OK){
            surname = data!!.getStringExtra("surname")
            name = ETName.text.toString().trim()
            TVDataHere.setText(name + " " + surname)
        }
    }
}
