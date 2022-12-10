package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.arrayOfShoes

class savedStateViewModel:ViewModel() {
    private var _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private var _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    init {
        _email.value = "-?"
        _password.value = "-?"
    }

    fun saveInstance(email:String,pass:String){
        _email.value = email
        _password.value = pass
    }
}