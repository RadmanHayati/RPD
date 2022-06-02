package com.codinginflow.exchangeApp.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    val name: String,
    val price: Double,
    val image: String,
    val history: List<List<Double>>? = null
) : Parcelable