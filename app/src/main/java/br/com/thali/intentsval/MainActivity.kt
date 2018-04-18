package br.com.thali.intentsval

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        private const val THIRD_ACTIVITY : Int = 3

    }

    @BindView(R.id.ETNome)
     lateinit var etNome:EditText

    @BindView(R.id.btnActivityTwo)
     lateinit var btnActivity: Button

    @BindView(R.id.btnActivityThree)
     lateinit var btnActivityThree : Button

    @BindView(R.id.TVDataHere)
     lateinit var TVdataHere : TextView

    @BindView(R.id.btnClear)
     lateinit var btnClear : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)



    }

    @OnClick(R.id.btnActivityTwo)
    fun OnClickBtnActivityTwo() {
        val nome: String = etNome.text.toString().trim()

        if (!TextUtils.isEmpty(ETNome.text.toString().trim()) ) {


            val intentTwo = Intent(this@MainActivity, TwoActivity::class.java)
            intentTwo.putExtra("nome", nome)
            startActivity(intentTwo)
        }else{
            Toast.makeText(this,"Por favor, Digite Seu Nome!!!", Toast.LENGTH_LONG).show()
        }
    }
    @OnClick(R.id.btnActivityThree)
    fun OnClickBtnActivityThree(){
        if (!TextUtils.isEmpty(ETNome.text.toString().trim()) ) {

            val intentThree = Intent(this@MainActivity, ThreeActivity::class.java)
            startActivityForResult(intentThree, THIRD_ACTIVITY)
        }else{
            Toast.makeText(this,"Por favor, Primeiramente Digite Seu Nome", Toast.LENGTH_LONG).show()
        }
    }


    @OnClick(R.id.btnClear)
    fun OnClickBtnClear() {
        ETNome.setText("")
        TVDataHere.setText("")

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
