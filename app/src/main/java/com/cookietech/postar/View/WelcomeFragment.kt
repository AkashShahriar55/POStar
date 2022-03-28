package com.cookietech.postar.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cookietech.postar.R
import com.cookietech.postar.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment() {

    lateinit var binding:FragmentWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.continueBtn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}