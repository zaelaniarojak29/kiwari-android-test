package com.example.kiwarichattest.network

class Message {

    constructor()

    constructor(messageText: String){
        text = messageText
    }
    var text: String? = null
    var timestamp: Long = System.currentTimeMillis()
}