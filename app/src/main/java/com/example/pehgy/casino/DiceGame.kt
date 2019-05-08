package com.example.pehgy.casino

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_dice_game.*
import java.util.*

class DiceGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_game)
        val coinSp = CoinSP(this)

        tvB_coin.text = CoinSP(this).B.toString()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("遊戲說明")
        builder.setMessage("擲骰子，點數較大則贏100，較小則輸150")
        builder.setPositiveButton("知道了",{ dialogInterface: DialogInterface, i: Int -> })
        builder.show()

        val dice_imgs1 = arrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )
        val dice_imgs2 = arrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )
        val r = Random()
        var x = 0
        var y = 0

        var coin = tvB_coin.text.toString()

        btnB_1.setOnClickListener {
            val intentB = Intent()
            val meg2 = coinSp.B.toString()
            intentB.putExtra("string", meg2)
            setResult(8, intentB)

            x = r.nextInt(6)
            y = r.nextInt(6)
            dice_1.setImageResource(dice_imgs1[x])
            dice_2.setImageResource(dice_imgs2[y])

            if (x > y) {
                coinSp.add()
                //Log.i("get test2222", "${coinSp.B}")
                //i=i+100
                tvB_win.text = "贏"
            } else if (y > x) {
                coinSp.sub()
                // i=i-100
                tvB_win.text = "輸"
            } else {
                tvB_win.text = "平手"
            }


            if (coinSp.B > 1) {
                tvB_coin.text = coinSp.B.toString()
            } else {
                tvB_coin.text = coinSp.B.toString()
                Toast.makeText(this, "請儲值再繼續", Toast.LENGTH_LONG).show()
                finish()
            }

        }
        btnB_back.setOnClickListener {
            val intentB = Intent()
            val meg2 = coinSp.B.toString()
            intentB.putExtra("string", meg2)
            setResult(8, intentB)
            finish()
        }
    }
}