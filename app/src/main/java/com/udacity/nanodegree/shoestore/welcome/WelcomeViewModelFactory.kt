package com.udacity.nanodegree.shoestore.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 9:44 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
class WelcomeViewModelFactory(private val email: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(email) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}