package com.example.kiwarichattest.model

data class user(
    @SerializedName("id") val Id: String,
    @SerializedName("type") val Type: String,
    @SerializedName("details") val details: ArrayList<DataUserModel> = arrayListOf()
) {
}