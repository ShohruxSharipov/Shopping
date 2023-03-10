package com.example.shopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import coil.load
import com.example.shopping.databinding.ActivityProductsBinding

class adapter(var list_name:MutableList<String>, var list:MutableMap<String,List<goods>>,var photos:List<String>):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return list_name.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return list.get(list_name.get(p0))!!.size
    }

    override fun getGroup(p0: Int): Any {
        return list_name[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return list.get(list_name[p0])!!.get(p1)
    }

    override fun getGroupId(p0: Int): Long {
        return getChildrenCount(p0).toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return getChildrenCount(p0).toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var binding = ActivityProductsBinding.inflate(LayoutInflater.from(p3!!.context),p3,false)
        binding.name.text = list_name[p0]
        binding.cost.text = ""
        binding.imageView.load(photos[p0]){
            error(R.drawable.img_1)
            placeholder(R.drawable.img_1)
        }
        return binding.root
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var binding = ActivityProductsBinding.inflate(LayoutInflater.from(p4!!.context),p4,false)
        binding.name.text = list.get(list_name.get(p0))!!.get(p1).name
        binding.cost.text = list.get(list_name.get(p0))!!.get(p1).cost
        binding.imageView.load(list.get(list_name.get(p0))!!.get(p1).img){
            placeholder(R.drawable.img_1)
            error(R.drawable.img_1)
        }
        return binding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return false
    }
}