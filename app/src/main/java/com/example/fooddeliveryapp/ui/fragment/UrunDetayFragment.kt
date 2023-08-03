package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentUrunDetayBinding
import com.example.fooddeliveryapp.ui.viewmodel.UrunDetayViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UrunDetayFragment : Fragment() {

    private lateinit var binding: FragmentUrunDetayBinding
    private lateinit var viewModel: UrunDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // Inflate via Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_urun_detay, container, false)
        binding.urunDetayFragment = this

        // amount işlemleri?

        val bundle:UrunDetayFragmentArgs by navArgs()
        binding.productObject = bundle.product

        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${bundle.product.yemek_resim_adi}"
        Glide.with(binding.imageViewProductDetail).load(imageUrl).into(binding.imageViewProductDetail)

        binding.buttonAddToCart.setOnClickListener {
            viewModel.sepeteYemekEkle(bundle.product.yemek_adi, bundle.product.yemek_resim_adi, bundle.product.yemek_fiyat)

            Navigation.findNavController(it).popBackStack()
            Snackbar.make(it, "Added to cart!", Snackbar.LENGTH_SHORT).show()
        }

        binding.textViewItemAmount.text = "0"
        viewModel.amount.observe(viewLifecycleOwner) {
            binding.textViewItemAmount.text = it.toString()
        }

        binding.fabIncrease.setOnClickListener {
            viewModel.increaseAmount()
        }

        binding.fabDecrease.setOnClickListener {
            viewModel.decreaseAmount()
        }

        binding.toolbarLogo.setNavigationIcon(R.drawable.icon_arrow_back)
        binding.toolbarLogo.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UrunDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}