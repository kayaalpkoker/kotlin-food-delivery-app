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
        // Inflate the layout via data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_urun_detay, container, false)
        binding.urunDetayFragment = this

        val bundle:UrunDetayFragmentArgs by navArgs()
        binding.productObject = bundle.product
        val product = bundle.product

        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${product.yemek_resim_adi}"
        Glide.with(binding.imageViewProductDetail).load(imageUrl).into(binding.imageViewProductDetail)

        binding.buttonAddToCart.setOnClickListener {
            viewModel.sepeteYemekEkle(product.yemek_adi, product.yemek_resim_adi, product.yemek_fiyat)

            Navigation.findNavController(it).popBackStack()
            Snackbar.make(it, "${product.yemek_adi} added to cart!", Snackbar.LENGTH_SHORT).show()
        }

        binding.textViewQuantity.text = "1"

        viewModel.quantity.observe(viewLifecycleOwner) { value ->
            binding.textViewQuantity.text = value.toString()

            val unitPrice = bundle.product.yemek_fiyat.toString().toDoubleOrNull() ?: 0.0
            val totalPrice = unitPrice * value
            binding.textViewQuantityPrice.text = String.format("₺ %.2f", totalPrice)

            if (value <= 1) {
                binding.fabDecrease.alpha = 0.1f
                binding.fabDecrease.isClickable = false
            } else {
                binding.fabDecrease.alpha = 1.0f
                binding.fabDecrease.isClickable = true
            }
        }

        binding.fabIncrease.setOnClickListener {
            viewModel.increaseQuantity()
        }

        binding.fabDecrease.setOnClickListener {
            viewModel.decreaseQuantity()
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