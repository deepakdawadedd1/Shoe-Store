package com.udacity.nanodegree.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 8:59 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
class LoginViewModel : ViewModel() {
    val emailField = MutableLiveData<String>()
    val passwordField = MutableLiveData<String>()
    val validateField = MediatorLiveData<Boolean>()
    private val _eventLoginComplete = MutableLiveData<Boolean>()
    val eventLoginComplete: LiveData<Boolean> get() = _eventLoginComplete

    init {
        validateField.addSource(emailField) {
            validate()
        }

        validateField.addSource(passwordField) {
            validate()
        }
    }

    fun login() {
        _eventLoginComplete.value = true
    }

    fun loginComplete() {
        _eventLoginComplete.value = false
    }

    private fun validate() {
        validateField.value =
            !emailField.value?.trim().isNullOrEmpty() && !passwordField.value?.trim()
                .isNullOrEmpty()
    }
}