package com.udacity.nanodegree.shoestore

import android.app.Application
import timber.log.Timber


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 8:31 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
class ShoeStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}