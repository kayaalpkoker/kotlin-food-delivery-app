package com.example.fooddeliveryapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.switchPage(it: View, id:Int) {
    Navigation.findNavController(it).navigate(id)
}

fun Navigation.switchPage(it:View,id: NavDirections){
    Navigation.findNavController(it).navigate(id)
}