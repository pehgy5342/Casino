package com.example.pehgy.casino

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_joker.*
import java.util.*

class Joker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joker)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("遊戲說明")
        builder.setMessage("兩個人同時翻牌，抽到鬼牌者為輸家")
        builder.setPositiveButton("知道了",{ dialogInterface: DialogInterface, i: Int -> })
        builder.show()


        val coinSp = CoinSP(this)
        coinvaule.text = CoinSP(this).B.toString()
        var cardlist1 = arrayOf(R.drawable.ha, R.drawable.da, R.drawable.sa, R.drawable.sa, R.drawable.joker)
        var cardlist2 = arrayOf(R.drawable.h2, R.drawable.d2, R.drawable.s2, R.drawable.s2, R.drawable.joker2)
        var r = Random()
        var a = 0
        var b = 0

        a = r.nextInt(5)
        b = r.nextInt(5)
        if (a == b) {
            b + 1

        } else if (a == 5) {
            b = 1

        } else {
        }



        c1.setOnClickListener {
            c1.setImageResource(cardlist1[a])
            //c1.setImageResource(R.drawable.ha)
            if (a == 4) {
                tv1.visibility = View.VISIBLE
                tv1.setText("你輸了")

            }

        }



        c2.setOnClickListener {
            c2.setImageResource(cardlist2[b])
            if (b == 4) {
                tv2.visibility = View.VISIBLE
                tv2.setText("你輸了")
            }
        }


        restart.setOnClickListener {
            c1.setImageResource(R.drawable.bg)
            c2.setImageResource(R.drawable.bg)
            a = r.nextInt(5)
            b = r.nextInt(5)
            tv1.visibility = View.INVISIBLE
            tv2.visibility = View.INVISIBLE
        }

        back.setOnClickListener {
                val intentB = Intent()
                val meg2 = coinSp.B.toString()
                intentB.putExtra("string",meg2)
                setResult(8,intentB)
                finish()
            }
        }

    }


