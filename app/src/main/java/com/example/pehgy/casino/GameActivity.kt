package com.example.pehgy.casino

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val coinSp = CoinSP(this)
        var coin = tv_value2.text.toString()
        tv_value2.text = coinSp.coins.toString()


        dicetime.text = coinSp.diceTimes.toString()
        pokertime.text = coinSp.JokerTimes.toString()

        Backhome.setOnClickListener {
            val intentB = Intent()
            val meg2 = coinSp.coins.toString()
            intentB.putExtra("string", meg2)
            setResult(8, intentB)
            finish()
        }
        Dice.setOnClickListener {
            //            Log.i("get test2222", "${coinSp.diceTimes}")
            if (coin.toInt() > 9) {
                //coinSp.gameTimes()
                val intent = Intent()
                intent.setClass(this@GameActivity, Dice::class.java)
                startActivityForResult(intent, 1)
                coinSp.gameTimes()
                dicetime.text = coinSp.diceTimes.toString()
                // Log.i("get test***", "${coinSp.diceTimes}")
            } else {
                Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
                finish()

            }

        }

        Poker.setOnClickListener {


            val intent = Intent()
            if (coin.toInt() > 9) {
                coinSp.cashSpent()
                intent.setClass(this@GameActivity, Joker::class.java)
                startActivityForResult(intent, 1)
                coinSp.gameTimes2()
                pokertime.text = coinSp.JokerTimes.toString()
            } else {
                Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
            }


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var coin = tv_value2.text.toString()
        when (resultCode) {
            8 -> {
                //val meg2 = data?.getStringExtra("string")
                val coinSp = CoinSP(this)
                tv_value2.text = coinSp.coins.toString()

                Dice.setOnClickListener {

                    if (coinSp.coins > 9) {
                        val intent = Intent()
                        intent.setClass(this@GameActivity, Dice::class.java)
                        startActivityForResult(intent, 1)
                        coinSp.gameTimes()
                        dicetime.text = coinSp.diceTimes.toString()
                        // Log.i("get test", "${coinSp.diceTimes}")
                    } else {
                        Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()

                    }

                }

                Poker.setOnClickListener {

                    val intent = Intent()
                    if (coin.toInt() > 9) {
                        coinSp.cashSpent()
                        intent.setClass(this@GameActivity, Joker::class.java)
                        startActivityForResult(intent, 1)
                        coinSp.gameTimes2()
                        pokertime.text = coinSp.JokerTimes.toString()
                    } else {
                        Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
                    }


                }

            }
        }
    }
}