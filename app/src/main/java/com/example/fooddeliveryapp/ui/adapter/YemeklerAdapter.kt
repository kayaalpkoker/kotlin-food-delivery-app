package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.entity.Yemekler
import com.example.fooddeliveryapp.databinding.CardDesignProductBinding
import com.example.fooddeliveryapp.ui.fragment.AnasayfaFragmentDirections
import com.example.fooddeliveryapp.ui.viewmodel.AnasayfaViewModel
import com.example.fooddeliveryapp.utils.switchPage


// Main
class YemeklerAdapter(var mContext:Context, var yemeklerListesi:List<Yemekler>, var viewModel:AnasayfaViewModel)
    : RecyclerView.Adapter<YemeklerAdapter.CardDesignProductHolder>() {

/*
// Alternative
class YemeklerAdapter(var mContext:Context, var yemeklerListesi:MutableLiveData<List<Yemekler>>, var viewModel:AnasayfaViewModel, var lifecycleOwner: LifecycleOwner)
    : RecyclerView.Adapter<YemeklerAdapter.CardDesignProductHolder>() {

    // If alternative is used
    init {
        yemeklerListesi.observe(lifecycleOwner) {
            notifyDataSetChanged()
        }
    }
 */

    inner class CardDesignProductHolder(var design:CardDesignProductBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignProductHolder {
        val binding : CardDesignProductBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design_product,parent,false)
        return CardDesignProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size //.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: CardDesignProductHolder, position: Int) {
        val product = yemeklerListesi.get(position) //.value!![position]
        val d = holder.design

        d.productObject = product

        d.cardViewProduct.setOnClickListener{
            val transition = AnasayfaFragmentDirections.switchHomepageToProductDetail(product = product)
            Navigation.switchPage(it,transition)
        }


        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${product.yemek_resim_adi}"
        Glide.with(mContext).load(imageUrl).override(300,300).into(d.imageViewProduct)
    }

}