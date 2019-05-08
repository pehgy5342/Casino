package com.example.pehgy.casino

import android.content.Context
import android.content.SharedPreferences

//import com.example.godsl.dicegame.R.id.tvA_coin
//import com.example.godsl.dicegame.R.id.tvB_coin

class CoinSP {

    var context: Context
    var times = 0
    var times2 = 0
    var B = 500
    var sharedPreferences:SharedPreferences
    var editor :SharedPreferences.Editor

    constructor(context: Context){
        this.context=context
        sharedPreferences = context.getSharedPreferences("name", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        B = sharedPreferences.getInt("output",500)
        times = sharedPreferences.getInt("playtime",0)
        times2 = sharedPreferences.getInt("playtime2",0)
    }
    fun input(){
        editor.putInt("output",B)
        editor.putInt("playtime",times)
        editor.putInt("playtime2",times2)
        editor.commit()
    }
    fun output(){
        val output = sharedPreferences.getInt("output",500)
        val playtime = sharedPreferences.getInt("playtime",0)
        val playtime2 = sharedPreferences.getInt("playtime2",0)
        //Log.i("******get test", "$output")
    }
    fun add(){
        B += 100
        input()
    }
    fun sub(){
        B -= 150

        input()
    }
    fun topup(money:Int){
        B += money
        input()
    }
    fun cashSpent(){
        B -= 10
        input()
    }
    fun gameTimes(){
        times ++
        input()
    }
    fun gameTimes2(){
        times2 ++
        input()
    }

//    fun getNumber(): Int {
//        val number = this.B
//        Log.i("get test", "$number")
//        return number
//    }

}
