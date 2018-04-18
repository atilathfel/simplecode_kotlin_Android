package br.com.thali.intentsval

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick


class TwoActivity : AppCompatActivity() {

    @BindView(R.id.TVBemVindo)
    lateinit var TVBemVindo : TextView

    @BindView(R.id.BtnVoltar)
    lateinit var btnVoltar : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        ButterKnife.bind(this)

        getStringExtra()



    }

    private fun getStringExtra() {
        //val editNome by lazy { intent.getStringExtra("nome") }
        var editNome = intent.getStringExtra("nome")
        TVBemVindo.setText( getString(R.string.bem_vindo) + editNome)
    }

    @OnClick(R.id.BtnVoltar)
    fun OnClickBtnVoltar(){
        finish()
    }




}