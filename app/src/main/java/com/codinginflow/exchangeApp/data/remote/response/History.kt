package com.codinginflow.exchangeApp.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class History(val prices: List<List<Double>>? = null):Parcelable
