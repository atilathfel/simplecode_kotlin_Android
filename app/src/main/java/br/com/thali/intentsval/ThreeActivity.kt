package br.com.thali.intentsval

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick


class ThreeActivity : AppCompatActivity(){


    @BindView(R.id.ETSobrenome)
    lateinit var ETSobrenome : EditText

    @BindView(R.id.BtnOk)
    lateinit var BtnOk : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        ButterKnife.bind(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @OnClick(R.id.BtnOk)
    fun OnClickBtnOk() {
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




}
