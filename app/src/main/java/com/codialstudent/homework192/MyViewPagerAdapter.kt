package com.codialstudent.homework192

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.codialstudent.homework192.databinding.ItemPagerBinding

class MyViewPagerAdapter(private val context: Context, val data: ArrayList<PageData>) :
    PagerAdapter() {
    override fun getCount(): Int = 4

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemPagerBinding = ItemPagerBinding.inflate(
                LayoutInflater.from(
                    context
                ), container, false
            )
        container.addView(itemPagerBinding.root)
itemPagerBinding.image.setImageResource(data[position].image)
        itemPagerBinding.tvName.text = data[position].name
        itemPagerBinding.tvDesc.text = data[position].description
        return itemPagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}