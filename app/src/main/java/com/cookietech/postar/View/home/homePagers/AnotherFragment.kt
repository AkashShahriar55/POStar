package com.cookietech.postar.View.home.homePagers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cookietech.postar.R


class AnotherFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_another, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AnotherFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}