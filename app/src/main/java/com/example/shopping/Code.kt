package com.example.shopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.shopping.databinding.ActivityCodeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Code : AppCompatActivity(),OnClickListener{
    lateinit var binding:ActivityCodeBinding
    var list = mutableListOf<ImageView>()
    var code = mutableListOf<String>()
    var n =0
    var pass = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(binding.first)
        list.add(binding.second)
        list.add(binding.third)
        list.add(binding.fourth)

        binding.one.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five.setOnClickListener(this)
        binding.six.setOnClickListener(this)
        binding.eight.setOnClickListener(this)
        binding.nine.setOnClickListener(this)
        binding.zero.setOnClickListener(this)
        binding.x.setOnClickListener{backspace(binding.x)}
    }

    override fun onClick(p0: View?) {
        var btn = findViewById<Button>(p0!!.id)
        pass += btn.text
        list[n].setBackgroundResource(R.drawable.baseline_circle_24)
        n++
        if (pass.length == 4){
            var type = object : TypeToken<List<String>>() {}.type
            var gson = Gson()

            var cache = getSharedPreferences("Cache", MODE_PRIVATE)
            var edit = cache.edit()

            var str = cache.getString("code","")
            if (str == ""){
                edit.putString("code", pass).apply()
                var intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }else {
                if (str == pass){
                    var intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }else binding.code.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim4))
            }
            pass = ""
            list.forEach{
                it.setBackgroundResource(R.drawable.outline_circle_24)
            }
            n=0
        }
    }
    fun backspace(btn:Button){
        if(pass.isNotEmpty()){
            n--
            list[n].setBackgroundResource(R.drawable.outline_circle_24)
            pass = pass.dropLast(1)
            Log.d("TAG", "backspace: ${pass}")
        }
    }
}