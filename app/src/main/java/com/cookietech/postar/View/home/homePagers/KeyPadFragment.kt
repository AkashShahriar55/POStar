package com.cookietech.postar.View.home.homePagers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cookietech.postar.R
import com.cookietech.postar.databinding.FragmentKeyPadBinding


class KeyPadFragment : Fragment() {
    
    lateinit var binding:FragmentKeyPadBinding


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
        binding = FragmentKeyPadBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            KeyPadFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}