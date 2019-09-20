package com.rdhd.app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.rdhd.app.fragments.CurrentServicesFragment
import com.rdhd.app.fragments.PassedServicesFragment

class ServicesPagerAdapter(supportFragment : FragmentManager) : FragmentStatePagerAdapter(supportFragment) {

    override fun getItem(position: Int) = if (position == 0) {
        PassedServicesFragment()
    } else {
        CurrentServicesFragment()
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = if (position == 0) {
        "قبلی"
    } else {
        "جاری"
    }
}