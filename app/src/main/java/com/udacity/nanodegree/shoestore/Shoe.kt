package com.udacity.nanodegree.shoestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by @author Deepak Dawade on 11/8/2020 at 8:30 PM.
 * Copyright (c) 2020 deepak.dawade.dd@gmail.com All rights reserved.
 *
 */
@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable