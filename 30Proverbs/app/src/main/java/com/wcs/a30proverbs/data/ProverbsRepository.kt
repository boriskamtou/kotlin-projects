package com.wcs.a30proverbs.data

import com.wcs.a30proverbs.R
import com.wcs.a30proverbs.models.Proverb

object ProverbsRepository {
    val proverbs = listOf<Proverb>(
        Proverb(
            proverbDay = R.string.proverb_day_1_day,
            proverbTitle = R.string.proverb_day_1_title,
            proverbDescription = R.string.proverb_day_1_description,
            proverbImage = R.drawable.img1,
        ),
        Proverb(
            proverbDay = R.string.proverb_day_2_day,
            proverbTitle = R.string.proverb_day_2_title,
            proverbDescription = R.string.proverb_day_2_description,
            proverbImage = R.drawable.img1,
        )
    )
}