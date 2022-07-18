package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _isLogedIn = MutableLiveData<Boolean>()
    val isLogedIn: LiveData<Boolean>
        get() = _isLogedIn

    private val _listOfShoes = MutableLiveData<MutableList<Shoe>>()
    val listOfShoes: LiveData<MutableList<Shoe>>
        get() = _listOfShoes

    init {
        _listOfShoes.value = mutableListOf()
        _isLogedIn.value = false
    }

    fun onSaveShoe(shoe: Shoe) {
        _listOfShoes.value?.add(shoe)
        _listOfShoes.value = _listOfShoes.value
    }

    fun onLogin(){
        _isLogedIn.value = true
    }

    fun onLogout(){
        _isLogedIn.value = false
    }
}