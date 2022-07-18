package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _listOfShoes = MutableLiveData<MutableList<Shoe>>()
    val listOfShoes: LiveData<MutableList<Shoe>>
        get() = _listOfShoes

    init {
        _listOfShoes.value = mutableListOf()
    }

    fun onSaveShoe(shoe: Shoe) {
        _listOfShoes.value?.add(shoe)
        _listOfShoes.value = _listOfShoes.value
    }
}