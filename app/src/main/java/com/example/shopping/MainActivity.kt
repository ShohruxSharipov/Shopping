package com.example.shopping

import  android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import coil.load
import com.example.shopping.databinding.ActivityMainBinding
import okhttp3.internal.notify
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var locale = Locale("uz")
        Locale.setDefault(locale)
        val config = Configuration()

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
                    locale = Locale("en")
                    config.locale = locale
                    baseContext.resources.updateConfiguration(
                        config,
                        baseContext.resources.displayMetrics)
                    binding.lan.text = "Select language"
                    binding.next.text = "next"
                }else{
                    locale = Locale("uz")
                    config.locale = locale
                    baseContext.resources.updateConfiguration(
                        config,
                        baseContext.resources.displayMetrics
                    )
                    binding.lan.text = "Tilni tanlang"
                    binding.next.text = "Keyingi"
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }



}