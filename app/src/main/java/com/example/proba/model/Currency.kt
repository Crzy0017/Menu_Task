package com.example.proba.model

import androidx.annotation.DrawableRes

data class Currency(
    val name: String,
    val value: Int,
    @DrawableRes val imageRes: Int
): Views
