package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList =  MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val count =  MutableLiveData<Int>()
    init {
        _shoeList.value = mutableListOf()
        count.value = 0
    }

    fun addShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
        _shoeList.value = _shoeList.value
        count.value = count.value?.plus(1)

    }



}