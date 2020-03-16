package com.example.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.slide_layout.view.*

class SliderAdapter(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    //Arrays For slider
    private val slideImages = arrayOf(R.drawable.code_image, R.drawable.eat_image, R.drawable.sleep_image)
    private val slideHeading = arrayListOf<String>("LEARN", "EAT", "SLEEP")

    override fun getCount(): Int {
        return slideHeading.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slide_layout, container, false)
        view.slide_image.setImageResource(slideImages[position])
        view.slide_text.text = slideHeading[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}