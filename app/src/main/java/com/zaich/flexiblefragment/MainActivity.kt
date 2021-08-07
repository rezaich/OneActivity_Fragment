package com.zaich.flexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragment = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragment.findFragmentByTag(HomeFragment::class.java.simpleName)

        if(fragment !is HomeFragment){
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            mFragment
                .beginTransaction()
                .add(R.id.frameContainer, mHomeFragment , HomeFragment::class.java.simpleName)
                .commit()

        }
    }
}