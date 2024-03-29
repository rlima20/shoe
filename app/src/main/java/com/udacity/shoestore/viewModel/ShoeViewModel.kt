package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    //Shoe
    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

    //Login
    var email: String = ""
    var password: String = ""

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

    fun onSaveShoe() {
        _listOfShoes.value?.add(
            Shoe(
                name.let { if (it.isEmpty()) "" else it },
                size.let { if (it.isEmpty()) 0.0 else size.toDouble() },
                company.let { if (it.isEmpty()) "" else it },
                description.let { if (it.isEmpty()) "" else it }
            )
        )
        _listOfShoes.value = _listOfShoes.value
    }

    fun onLogin() {
        _isLogedIn.value = true
    }

    fun onLogout() {
        _isLogedIn.value = false
        onCleared()
    }

    override fun onCleared() {
        super.onCleared()
        name = ""
        size = ""
        company = ""
        description = ""
        email = ""
        password = ""
        _listOfShoes.value?.clear()
    }
}