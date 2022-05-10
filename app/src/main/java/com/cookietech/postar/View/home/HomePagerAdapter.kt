package com.cookietech.postar.View.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cookietech.postar.View.home.homePagers.AnotherFragment
import com.cookietech.postar.View.home.homePagers.InventoryFragment
import com.cookietech.postar.View.home.homePagers.KeyPadFragment

class HomePagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {



    override fun getItemCount(): Int {
        return homePagers.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(homePagers[position]){
            HomePagers.Keypad-> KeyPadFragment.newInstance()
            HomePagers.Inventory -> InventoryFragment.newInstance()
            HomePagers.Another -> AnotherFragment.newInstance()
        }
    }
}