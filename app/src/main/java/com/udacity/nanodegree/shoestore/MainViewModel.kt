package com.udacity.nanodegree.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 11:57 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
class MainViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    init {
        _shoeList.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe) {
        val shoes = _shoeList.value
        shoes?.add(shoe)
        _shoeList.value = shoes
    }
}