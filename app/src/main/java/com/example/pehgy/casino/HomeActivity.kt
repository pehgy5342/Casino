package com.example.pehgy.casino

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val coinSp = CoinSP(this)
        //Log.i("get test2222", "${coinSp.B}")
        tvA_coin.text = coinSp.B.toString()
        var coinNow = coinSp.B.toString()
        btnA_1.setOnClickListener {
          // Log.i("get test2222", "${coinNow}")
            var intent = Intent()
            if (coinNow.toInt() > 9) {
                intent.setClass(this@HomeActivity, SecondActivity::class.java)
                startActivityForResult(intent, 1)
            } else {
                Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
            }
        }

        btnA_2.setOnClickListener {
            var intent = Intent()
            intent.setClass(this@HomeActivity, Cash::class.java)
            startActivityForResult(intent, 1)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            8 -> {
                //val meg2 = data?.getStringExtra("string")
                val coinSp = CoinSP(this)
                tvA_coin.text = coinSp.B.toString()
                var coinNow = tvA_coin.text.toString().toInt()
                btnA_1.setOnClickListener {
                   // Log.i("get test2222", "${coinNow}")
                    var intent = Intent()
                    if (coinNow.toInt() > 9) {
                        intent.setClass(this@HomeActivity, SecondActivity::class.java)
                        startActivityForResult(intent, 1)
                    } else {
                        Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
                    }
                }

                btnA_2.setOnClickListener {
                    var intent = Intent()
                    intent.setClass(this@HomeActivity, Cash::class.java)
                    startActivityForResult(intent, 1)
                }

            }
        }
    }
}