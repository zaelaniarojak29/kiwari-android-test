package com.example.kiwarichattest.network.response

class LoginResponse (@SerializedName("status") val status: StatusReponse,
                     @SerializedName("results") val results: ResultsReponse,) {
}