package com.example.kiwarichattest.network.request

data class LoginRequest(
    @SerializedName("username") val user: String,
    @SerializedName("password") val pass: String
)