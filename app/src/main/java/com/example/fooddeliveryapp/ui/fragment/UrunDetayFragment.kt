package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddeliveryapp.databinding.FragmentUrunDetayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UrunDetayFragment : Fragment() {

    private lateinit var binding: FragmentUrunDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUrunDetayBinding.inflate(inflater, container, false)



        return binding.root
    }

}