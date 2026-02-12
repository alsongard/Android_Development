package com.example.courses_app.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TopicModel(
    @StringRes var courseTitle: Int,
    var courseNumber: String,
    @DrawableRes var courseImage: Int
)

