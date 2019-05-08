package com.example.pehgy.casino

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dice_game.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val coinSp = CoinSP(this)

        tvS_coin.text = coinSp.B.toString()
        var coinNow = tvS_coin.text.toString()

        dicetime.text = coinSp.times.toString()
        pokertime.text = coinSp.times2.toString()

        Backhome.setOnClickListener {
            val intentB = Intent()
            val meg2 = coinSp.B.toString()
            intentB.putExtra("string",meg2)
            setResult(8,intentB)
            finish()
        }
        Dice.setOnClickListener {
//            Log.i("get test2222", "${coinSp.times}")
            if (coinNow.toInt() >9) {
                //coinSp.gameTimes()
                var intent = Intent()
                intent.setClass(this@SecondActivity,DiceGame::class.java)
                startActivityForResult(intent, 1)
                coinSp.gameTimes()
                dicetime.text = coinSp.times.toString()
               // Log.i("get test***", "${coinSp.times}")
            }
            else {
                Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
                finish()

            }

        }

        Poker.setOnClickListener {


            var intent = Intent()
            if (coinNow.toInt() > 9) {
                coinSp.cashSpent()
                intent.setClass(this@SecondActivity,Joker::class.java)
                startActivityForResult(intent, 1)
                coinSp.gameTimes2()
                pokertime.text = coinSp.times2.toString()
            } else {
                Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
            }


        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            8 -> {
                //val meg2 = data?.getStringExtra("string")
                val coinSp = CoinSP(this)
                tvS_coin.text = coinSp.B.toString()
                var coinNow = tvS_coin.text.toString()
                Dice.setOnClickListener {

                    if (coinSp.B.toInt() >9) {
                        var intent = Intent()
                        intent.setClass(this@SecondActivity,DiceGame::class.java)
                        startActivityForResult(intent, 1)
                        coinSp.gameTimes()
                        dicetime.text = coinSp.times.toString()
                       // Log.i("get test", "${coinSp.times}")
                    }
                    else {
                        Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()

                    }

                }

                Poker.setOnClickListener {

                    var intent = Intent()
                    if (coinNow.toInt() > 9) {
                        coinSp.cashSpent()
                        intent.setClass(this@SecondActivity,Joker::class.java)
                        startActivityForResult(intent, 1)
                        coinSp.gameTimes2()
                        pokertime.text = coinSp.times2.toString()
                    } else {
                        Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
                    }


                }

            }
        }
    }
}