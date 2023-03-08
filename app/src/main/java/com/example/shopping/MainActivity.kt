package com.example.shopping

import  android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import coil.load
import com.example.shopping.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lang = listOf<String>("English","Uzbek")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lang)
        binding.spinner.adapter = adapter



        binding.next.setOnClickListener {
            var intent = Intent(this,registration::class.java)
            startActivity(intent)
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (lang[p2] == "English"){
                    var context = LocaleHelper(this@MainActivity,"en")
                    var  resources = context::class.java.classLoader.getResources("")
                }else Toast.makeText(this@MainActivity, "UZ", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }



}