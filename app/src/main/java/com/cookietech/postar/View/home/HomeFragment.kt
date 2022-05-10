package com.cookietech.postar.View.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.cookietech.postar.R
import com.cookietech.postar.databinding.FragmentHomeBinding
import com.cookietech.postar.viewUtils.sp

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPagers()
    }

    private fun setUpPagers() {
        activity?.let {
            val pagerAdapter = HomePagerAdapter(it)
            binding.homePager.adapter = pagerAdapter

            binding.homePager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    Log.d("pager", "onPageScrolled: $position $positionOffset $positionOffsetPixels")

                    val nextPageSize = 1f + (0.3f * positionOffset)
                    val prevPageSize = 1.3f - (0.3f * positionOffset)
                    if(position == 0){

                        binding.tvKeypad.setTextColor(Color.parseColor("#FFFFFFFF"))
                        binding.tvInventory.setTextColor(Color.parseColor("#CCFFFFFF"))
                        binding.tvAnother.setTextColor(Color.parseColor("#CCFFFFFF"))
                        binding.tvKeypad.scaleX = prevPageSize
                        binding.tvKeypad.scaleY = prevPageSize
                        binding.tvInventory.scaleX = nextPageSize
                        binding.tvInventory.scaleY = nextPageSize
                    }else if(position == 1){
                        binding.tvKeypad.setTextColor(Color.parseColor("#CCFFFFFF"))
                        binding.tvInventory.setTextColor(Color.parseColor("#FFFFFFFF"))
                        binding.tvAnother.setTextColor(Color.parseColor("#CCFFFFFF"))
                        binding.tvInventory.scaleX = prevPageSize
                        binding.tvInventory.scaleY = prevPageSize
                        binding.tvAnother.scaleX = nextPageSize
                        binding.tvAnother.scaleY = nextPageSize

                    }else if(position == 2){
                        binding.tvKeypad.setTextColor(Color.parseColor("#CCFFFFFF"))
                        binding.tvInventory.setTextColor(Color.parseColor("#CCFFFFFF"))
                        binding.tvAnother.setTextColor(Color.parseColor("#FFFFFFFF"))
                        binding.tvAnother.scaleX = prevPageSize
                        binding.tvAnother.scaleY = prevPageSize
                    }


                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }
            })

        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}