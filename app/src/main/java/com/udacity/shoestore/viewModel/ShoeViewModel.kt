package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes: LiveData<List<Shoe>>
        get() = _listOfShoes
}