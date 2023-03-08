package com.example.shopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var list = mutableListOf<goods>()
    lateinit var search: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val anim = AnimationUtils.loadAnimation(this,R.anim.anim)
        binding.RV.animation = anim
        list.add(goods("https://assets.stickpng.com/images/61d2f85b92b57c0004c64745.png","iPhone 13","790 $"))
        list.add(goods("https://www.transparentpng.com/thumb/iphone-7/black-iphone-7-plus-transparent-free-WNS7Z9.png","iPhone 7+","550 $"))
        list.add(goods("https://cdn.shopify.com/s/files/1/1684/4603/products/samsungGalaxyA30_Black.png?v=1620369553","Samsung A30","600 $"))
        list.add(goods("https://shop.samsung.com/ie/business/images/products/27511/14946/600x600/SM-G998BZKDEUA.png","Samsung S21","760 $"))
        list.add(goods("https://9mi.ru/wp-content/uploads/2020/10/remont_telefonov_Xiaomi_-RedmiNote7.png","RedMI Note 7","650 $"))
        list.add(goods("https://zoodmall.com/cdn-cgi/image/w=600,fit=contain,f=auto/https://images.zoodmall.com/cloudinary/30/ee4/https%253A%252F%252Favatars.mds.yandex.net%252Fget-mpic%252F6237625%252Fimg_id722085418157885263.png%252Forig","Redmi Note 11","760 $"))
        list.add(goods("https://assets.stickpng.com/images/61d2f85b92b57c0004c64745.png","iPhone 13","790 $"))
        list.add(goods("https://www.transparentpng.com/thumb/iphone-7/black-iphone-7-plus-transparent-free-WNS7Z9.png","iPhone 7+","550 $"))
        list.add(goods("https://cdn.shopify.com/s/files/1/1684/4603/products/samsungGalaxyA30_Black.png?v=1620369553","Samsung A30","600 $"))
        list.add(goods("https://shop.samsung.com/ie/business/images/products/27511/14946/600x600/SM-G998BZKDEUA.png","Samsung S21","760 $"))
        list.add(goods("https://9mi.ru/wp-content/uploads/2020/10/remont_telefonov_Xiaomi_-RedmiNote7.png","RedMI Note 7","650 $"))
        var adapter = products(list)

        binding.editt.addTextChangedListener {
            var goodFilter = mutableListOf<goods>()
            if (it!!.length > 0 && it != null){
                for (u in list){
                    if (u.name!!.contains(it)){
                        goodFilter.add(u)
                    }
                }
                adapter = products(goodFilter)

            }else  adapter = products(list)
            binding.RV.adapter = adapter
        }
        binding.RV.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.RV.adapter =  adapter
        adapter.onItemClick = {

            var intent = Intent(this,item_activity::class.java)
            startActivity(intent)
        }


    }


}