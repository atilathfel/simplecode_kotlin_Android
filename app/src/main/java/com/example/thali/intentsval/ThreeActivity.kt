package com.example.thali.intentsval

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.thali.myproject1404.R

class ThreeActivity : AppCompatActivity() , View.OnClickListener{

    private val ETSobrenome by lazy { findViewById<EditText>(R.id.ETSobrenome) }
    private val btnOK by lazy { findViewById<Button>(R.id.BtnOk) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)


        btnOK.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        val sobrenome : String = ETSobrenome.text.toString().trim()

        if (!ETSobrenome.text.toString().trim().equals("")) {

            val intentThree = Intent()
            intentThree.putExtra("sobrenome", sobrenome)
            setResult(RESULT_OK, intentThree)

            finish()
        }else{
            Toast.makeText(this,"Por favor,Digite Seu Sobrenome!!!",Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_back) {
            val intent = Intent(this@ThreeActivity, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
