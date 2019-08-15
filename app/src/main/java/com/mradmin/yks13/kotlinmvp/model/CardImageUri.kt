package com.mradmin.yks13.kotlinmvp.model

import com.google.gson.annotations.SerializedName

data class CardImageUri (
        @SerializedName("small") val small: String?,
        @SerializedName("normal") val normal: String?,
        @SerializedName("large") val large: String?)