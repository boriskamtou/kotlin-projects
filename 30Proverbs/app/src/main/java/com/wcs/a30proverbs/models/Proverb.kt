package com.wcs.a30proverbs.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Proverb(
    @StringRes val proverbDay: Int,
    @StringRes val proverbTitle: Int,
    @StringRes val proverbDescription: Int,
    @DrawableRes val proverbImage: Int
)
