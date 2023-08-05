package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.entity.SepetYemekler
import com.example.fooddeliveryapp.databinding.CardDesignCartBinding
import com.example.fooddeliveryapp.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar

class SepetYemeklerAdapter(var mContext: Context, var sepetYemeklerListesi: List<SepetYemekler>, var viewModel: SepetViewModel)
    : RecyclerView.Adapter<SepetYemeklerAdapter.CardDesignCartHolder>() {

    inner class CardDesignCartHolder(var design: CardDesignCartBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignCartHolder {
        val binding : CardDesignCartBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design_cart,parent,false)
        return CardDesignCartHolder(binding)
    }

    override fun getItemCount(): Int {
        return sepetYemeklerListesi.size
    }

    override fun onBindViewHolder(holder: CardDesignCartHolder, position: Int) {
        val cartItem = sepetYemeklerListesi.get(position)
        val d = holder.design

        d.cartObject = cartItem

        d.imageViewDeleteItem.setOnClickListener {
            Snackbar
                .make(it, "Do you want to remove ${cartItem.yemek_adi} from cart?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.sepettenYemekSil(cartItem.sepet_yemek_id)
                }
                .show()
        }

        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${cartItem.yemek_resim_adi}"
        Glide.with(mContext).load(imageUrl).override(300,300).into(d.imageViewCartItem)
    }

}