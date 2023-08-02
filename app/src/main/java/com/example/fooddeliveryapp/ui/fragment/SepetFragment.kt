package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddeliveryapp.databinding.FragmentSepetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {

    private lateinit var binding: FragmentSepetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSepetBinding.inflate(inflater, container, false)



        return binding.root
    }

}