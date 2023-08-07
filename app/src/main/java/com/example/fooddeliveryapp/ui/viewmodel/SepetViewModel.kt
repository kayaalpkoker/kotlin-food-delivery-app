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
class SepetViewModel @Inject constructor(var syrepo: SepetYemeklerRepository) : ViewModel() {

    var sepetYemeklerListesi = MutableLiveData<List<SepetYemekler>>()

    init {
        sepettekiYemekleriGetir()
    }

    fun sepettekiYemekleriGetir() {
        CoroutineScope(Dispatchers.Main).launch {
            val yemekler = syrepo.sepettekiYemekleriGetir()
            sepetYemeklerListesi.value = yemekler
        }
    }

    fun sepettenYemekSil(sepet_yemek_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            syrepo.sepettenYemekSil(sepet_yemek_id)
            sepettekiYemekleriGetir()
        }
    }

    fun calculateTotalPrice(): Int {
        return sepetYemeklerListesi.value?.sumOf { it.yemek_fiyat * it.yemek_siparis_adet } ?: 0
    }

}