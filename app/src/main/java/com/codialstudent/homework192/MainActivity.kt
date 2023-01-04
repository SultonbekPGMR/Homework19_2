package com.codialstudent.homework192

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.codialstudent.homework192.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = MyViewPagerAdapter(this, getData())
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.setOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position==3){
                    binding.btnNext.visibility = View.INVISIBLE
                    binding.arrow.visibility = View.INVISIBLE
                }else{
                    binding.btnNext.visibility = View.VISIBLE
                    binding.arrow.visibility = View.VISIBLE
                }

            }

            override fun onPageScrollStateChanged(state: Int) { }
        })

        binding.btnNext.setOnClickListener {
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
        }

        binding.btnSkip.setOnClickListener {
            binding.btnNext.visibility = View.INVISIBLE
            binding.btnSkip.visibility = View.INVISIBLE
            binding.viewPager.visibility = View.INVISIBLE
            binding.tabLayout.visibility = View.INVISIBLE
            binding.arrow.visibility = View.INVISIBLE

            binding.root.setBackgroundColor(Color.BLACK)
            binding.tvSkip.visibility = View.VISIBLE
        }

    }

    fun getData(): ArrayList<PageData> {
        val list = ArrayList<PageData>()
        list.add(
            PageData(
                "Click va Paymega o’tish xizmati",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.",
                R.drawable.img1
            )
        )
        list.add(
            PageData(
                "Barcha operatorlar bo’yicha statistika",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.",
                R.drawable.img2
            )
        )
        list.add(
            PageData(
                "Tariflarni filtrlash",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.",
                R.drawable.img3
            )
        )
        list.add(
            PageData(
                "Yangi imkoniyatlar",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.",
                R.drawable.img4
            )
        )



        return list
    }

}