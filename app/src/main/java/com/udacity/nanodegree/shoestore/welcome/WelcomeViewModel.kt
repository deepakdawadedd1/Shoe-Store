package com.udacity.nanodegree.shoestore.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 9:43 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
class WelcomeViewModel(email: String) : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _eventInstructions = MutableLiveData<Boolean>()
    val eventInstruction: LiveData<Boolean> get() = _eventInstructions

    init {
        _email.value = email
        _eventInstructions.value = false
    }

    fun navigateToInstructions() {
        _eventInstructions.value = true
    }

    fun navigateToInstructionsComplete() {
        _eventInstructions.value = false
    }
}