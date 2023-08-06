package com.example.fooddeliveryapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.data.entity.SepetYemekler
import com.example.fooddeliveryapp.data.repo.SepetYemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UrunDetayViewModel @Inject constructor(var syrepo: SepetYemeklerRepository) : ViewModel() {

    val amount = MutableLiveData(1)

    fun increaseAmount() {
        amount.value = (amount.value ?: 1) + 1
    }

    fun decreaseAmount() {
        if ((amount.value ?: 1) > 1)
            amount.value = amount.value!! - 1
    }

    suspend fun checkProductInCart(yemek_adi: String): SepetYemekler? {
        val cartItems = syrepo.sepettekiYemekleriGetir()
        return cartItems.find { it.yemek_adi == yemek_adi }
    }

    fun sepeteYemekEkle(yemek_adi: String,
                        yemek_resim_adi: String,
                        yemek_fiyat: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            val existingProduct = checkProductInCart(yemek_adi)
            if (existingProduct != null) {
                // If product already exists in the cart, delete it and then add with updated quantity
                syrepo.sepettenYemekSil(existingProduct.sepet_yemek_id)
                syrepo.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, existingProduct.yemek_siparis_adet + amount.value!!)
            } else {
                // If product doesn't exist in the cart, add it with user-chosen quantity
                syrepo.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, amount.value!!)
            }
        }
    }

}