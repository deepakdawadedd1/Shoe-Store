package com.udacity.nanodegree.shoestore.shoedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.nanodegree.shoestore.Shoe


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 11:39 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
class ShoeDetailViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val validator = MediatorLiveData<Boolean>()

    private val _eventBackToShoeList = MutableLiveData<Boolean>()
    val eventBackToShoeList: LiveData<Boolean> get() = _eventBackToShoeList
    private val _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe> get() = _newShoe

    init {
        _eventBackToShoeList.value = false
        validator.addSource(shoeName) {
            validator.value = validateField()
        }
        validator.addSource(company) {
            validator.value = validateField()
        }
        validator.addSource(size) {
            validator.value = validateField()
        }
        validator.addSource(description) {
            validator.value = validateField()
        }
    }

    private fun validateField(): Boolean {
        val name = !shoeName.value?.trim().isNullOrEmpty()
        val company = !company.value?.trim().isNullOrEmpty()
        val size = !size.value?.trim().isNullOrEmpty()
        val description = !description.value?.trim().isNullOrEmpty()
        return name && company && size && description
    }

    fun cancel() {
        _eventBackToShoeList.value = true
    }

    fun save() {
        val name = shoeName.value ?: ""
        val size = size.value ?: ""
        val company = company.value ?: ""
        val description = description.value ?: ""
        val shoe = Shoe(
            name = name,
            size = size.toDoubleOrNull() ?: 0.0,
            company = company,
            description = description
        )
        _newShoe.value = shoe
        _eventBackToShoeList.value = true
    }

    fun navigationDone() {
        _eventBackToShoeList.value = false
    }
}