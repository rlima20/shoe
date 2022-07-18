package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _size = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _size

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val _isLogedIn = MutableLiveData<Boolean>()
    val isLogedIn: LiveData<Boolean>
        get() = _isLogedIn

    private val _listOfShoes = MutableLiveData<MutableList<Shoe>>()
    val listOfShoes: LiveData<MutableList<Shoe>>
        get() = _listOfShoes

    init {
        _listOfShoes.value = mutableListOf()
        _isLogedIn.value = false
        _name.value  = ""
    }

    fun onSaveShoe() {
        _listOfShoes.value?.add(
            Shoe(
                _name.value.toString(),
                _size.value?.toDouble(),
                _company.value.toString(),
                _description.value.toString()
            )
        )
        _listOfShoes.value = _listOfShoes.value
    }

    fun onLogin() {
        _isLogedIn.value = true
    }

    fun onLogout() {
        _isLogedIn.value = false
    }
}