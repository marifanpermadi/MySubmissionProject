package com.example.mysubmissionproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Foods(
    val name: String,
    val description: String,
    val photo: Int,
    val price: String,
    val origin: String
): Parcelable
