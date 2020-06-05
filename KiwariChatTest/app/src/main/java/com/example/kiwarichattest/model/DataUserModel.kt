package com.example.kiwarichattest.model

data class DataUserModel (
    @SerializedName("user_id") val userId: String,
    @SerializedName("user_name") val userName: String,
    @SerializedName("avatar") val Avatar: String,
    @SerializedName("email") val Email: String,
    @SerializedName("password") val Password: String, ) {
}