package com.example.pehgy.casino

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_cash.*

class Cash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)
        val coinSp = CoinSP(this)
        tvD_coin.text = coinSp.B.toString()
        btn_topupInput.setOnClickListener {
            coinSp.topup(money = et_topup.text.toString().toInt())
            tvD_coin.text = coinSp.B.toString()
            Toast.makeText(this, "儲值成功", Toast.LENGTH_LONG).show()
        }
        btn_topupBack.setOnClickListener {
            val intentB = Intent()
            val meg2 = coinSp.B.toString()
            intentB.putExtra("string",meg2)
            setResult(8,intentB)
            finish()
        }
    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (resultCode) {
//            8 -> {
//                //val meg2 = data?.getStringExtra("string")
//                val coinSp = CoinSP(this)
//                tvD_coin.text = coinSp.B.toString()
//
//            }
//        }
//    }
}