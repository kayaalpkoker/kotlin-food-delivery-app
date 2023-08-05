package com.example.fooddeliveryapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun sepeteYemekEkle(yemek_adi: String,
                        yemek_resim_adi: String,
                        yemek_fiyat: Int){
        CoroutineScope(Dispatchers.Main).launch {
            syrepo.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat, amount.value!!)
        }
    }

}