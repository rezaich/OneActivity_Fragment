package com.zaich.flexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_category.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_category){
            val mCategoryFragment = CategoryFragment()
            val mFragmentCategory = fragmentManager
            mFragmentCategory?.beginTransaction()?.apply {
                replace(R.id.frameContainer,mCategoryFragment,CategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

    }

}