package com.example.onboarding

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.onboarding.Fragments.FragmentFour
import com.example.onboarding.Fragments.FragmentOne
import com.example.onboarding.Fragments.FragmentThree
import com.example.onboarding.Fragments.FragmentTwo

class ViewPagerAdapter(private val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList: MutableList<Fragment> =
        arrayListOf(FragmentOne(), FragmentTwo(), FragmentThree(), FragmentFour())
    private val titleList: MutableList<String> = arrayListOf(
        "One",
        "Two",
        "Three",
        "Four"
    )

    override fun getItem(position: Int): Fragment {
        Log.i("AdapterClass" , "getItem Called $position")
        return fragmentList[position]
    }

    override fun getCount(): Int {
        Log.i("AdapterClass" , "getCount called ${fragmentList.size}" )
        return fragmentList.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        Log.i("AdapterClass" , "getPageTitle Called $position")
        return titleList[position]

    }
}