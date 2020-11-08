package com.udacity.nanodegree.shoestore.login

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

    init {
        validateField.addSource(emailField) {
            validate()
        }

        validateField.addSource(passwordField) {
            validate()
        }
    }

    fun login() {

    }

    private fun validate() {
        validateField.value =
            !emailField.value.isNullOrEmpty() && !passwordField.value.isNullOrEmpty()
    }
}