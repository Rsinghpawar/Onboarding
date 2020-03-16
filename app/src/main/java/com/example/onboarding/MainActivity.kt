package com.example.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.INVISIBLE
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.onboarding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    //private val mDots: ArrayList<TextView> = ArrayList(3)
    private lateinit var mDots: Array<TextView>
    private var currentPage  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ActivityMessage" , "On Create")
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sliderAdapter = SliderAdapter(this)
        slideViewPager.adapter = sliderAdapter
        addDotsIndicator(0)
        slideViewPager.addOnPageChangeListener(listener)

        //onClickListener

        binding.btnNext.setOnClickListener{
            if (currentPage>=2)
                Toast.makeText(this,"Destination Activity Not Created" , Toast.LENGTH_SHORT).show()
            else
                slideViewPager.currentItem = currentPage+1
        }
        btn_back.setOnClickListener{
            slideViewPager.currentItem = currentPage-1
        }


    }

    private val listener = object : OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }

        override fun onPageSelected(position: Int) {
            addDotsIndicator(position)
            currentPage=position

            when (position) {
                0 -> {
                    btn_back.visibility= View.INVISIBLE
                    btn_back.isEnabled = false
                    btn_next.isEnabled= true
                    btn_back.text=""
                }
                mDots.size-1 -> {
                    btn_back.isEnabled = true
                    btn_next.isEnabled= true
                    btn_next.text="Finish"
                    btn_back.visibility=View.VISIBLE
                }
                else -> {
                    btn_back.isEnabled = true
                    btn_next.isEnabled= true
                    btn_back.text="Back"
                    btn_next.text="Next"
                    btn_back.visibility= View.VISIBLE
                }
            }


        }
    }

    private fun addDotsIndicator(position: Int) {

        mDots = Array<TextView>(3) { TextView(this) }
        dotsLayout.removeAllViews()

        for (i in 0..2) {

            mDots[i] == TextView(this)
            mDots[i].text = Html.fromHtml("&#8226;")
            mDots[i].textSize = 35F
            if (i != position)
                mDots[i].setTextColor(ContextCompat.getColor(this, R.color.listIndicator))
            else mDots[position].setTextColor(ContextCompat.getColor(this, R.color.colorWhite))

            dotsLayout.addView(mDots[i])

        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("ActivityMessage" , "On Start")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ActivityMessage" , "On Pause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ActivityMessage" , "On Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ActivityMessage" , "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ActivityMessage" , "On Destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ActivityMessage" , "On Restart")
    }
}
