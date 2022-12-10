package com.udacity.shoestore.screens.showList

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.arrayOfShoes

class ShoeListViewModel:ViewModel() {

    private var _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList:LiveData<ArrayList<Shoe>>
    get() = _shoeList

    var shoename = MutableLiveData<String>()
    var shoecompany = MutableLiveData<String>()
    var shoesize = MutableLiveData<String>()
    var shoedesc = MutableLiveData<String>()


    init {
        _shoeList.value = arrayOfShoes
    }

    fun addShoeEntry(shoe: Shoe){
        arrayOfShoes.add(shoe)
        _shoeList.value = arrayOfShoes
    }

    fun setShoeNameValue(text: CharSequence,start: Int,before : Int,
                         count :Int){
        shoename.value = text.toString()
    }
    fun setShoeCompanyValue(text: CharSequence,start: Int,before : Int,
                            count :Int){
        shoecompany.value = text.toString()
    }
    fun setShoeSizeValue(text: CharSequence,start: Int,before : Int,
                         count :Int){
        shoesize.value = text.toString()
    }
    fun setShoeDescValue(text: CharSequence,start: Int,before : Int,
                         count :Int){
        shoedesc.value = text.toString()
    }

    fun addShoeEntry2(){
        val name = shoename.value
        val company = shoecompany.value
        val size = shoesize.value
        val desc = shoedesc.value
        val shoe = Shoe(name!!,size!!,company!!,desc!!, listOf())

        arrayOfShoes.add(shoe)
        _shoeList.value = arrayOfShoes
    }
}