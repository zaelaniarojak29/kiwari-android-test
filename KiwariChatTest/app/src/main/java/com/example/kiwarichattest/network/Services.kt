package com.example.kiwarichattest.network

import com.example.kiwarichattest.network.request.LoginRequest
import com.example.kiwarichattest.network.response.LoginResponse

interface Services {

    @POST("")
    fun userLogin(@Body loginRequest: LoginRequest): Flowable<LoginResponse>
}