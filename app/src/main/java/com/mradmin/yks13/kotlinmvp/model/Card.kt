package com.mradmin.yks13.kotlinmvp.model

import com.google.gson.annotations.SerializedName

data class Card(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("type_line") val type: String,
        @SerializedName("oracle_text") val oracleText: String,
        @SerializedName("artist") val artist: String,
        @SerializedName("image_uris") val imageUris: CardImageUri?) {

}