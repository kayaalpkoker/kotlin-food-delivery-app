package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentAnasayfaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.anasayfaFragment -> {
                    // Do nothing for now
                    true
                }
                R.id.sepetFragment -> {
                    findNavController().navigate(R.id.switchHomepageToCart)
                    true
                }
                else -> false
            }
        }
    }

}