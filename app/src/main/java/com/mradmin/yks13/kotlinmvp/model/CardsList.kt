package com.mradmin.yks13.kotlinmvp.model

import com.google.gson.annotations.SerializedName

data class CardsList(
        @SerializedName("object") override val result: String,
        @SerializedName("details") override val details: String,
        @SerializedName("data") val data: List<Card>) : ApiResponse{}