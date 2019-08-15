package com.mradmin.yks13.kotlinmvp.model

import com.google.gson.annotations.SerializedName

interface ApiResponse {
    val result: String
    val details: String
}
