package com.rdhd.app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.rdhd.app.fragments.NewCardFormFragment

class NewCardFormPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int) : Fragment {
        return when (position) {
            0 -> {
                NewCardFormFragment.newInstance("شماره ی کارت", "شماره کارت ۱۶ رقمی", "serial")
            }
            1 -> {
                NewCardFormFragment.newInstance("CVV2", "شناسه CVV2", "cvv2")
            }
            2 -> {
                NewCardFormFragment.newInstance("تاریخ انقضا", "سال/ماه", "date")
            }
            3 -> {
                NewCardFormFragment.newInstance("رمز دوم", "رمز دوم کارت", "password")
            }
            else -> {
                NewCardFormFragment.newInstance("رمز دوم", "رمز دوم کارت", "password")
            }
        }
    }

    override fun getCount() = 4

}