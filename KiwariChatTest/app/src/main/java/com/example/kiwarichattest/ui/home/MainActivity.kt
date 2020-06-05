package com.example.kiwarichattest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kiwarichattest.ui.home.MessageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupSendButton() {
        mainActivitySendButton.setOnClickListener {
            if (!mainActivityEditText.text.toString().isEmpty()){
                sendData()
            }else{
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendData(){
        databaseReference?.
        child("messages")?.
        child(java.lang.String.valueOf(System.currentTimeMillis()))?.
        setValue(Message(mainActivityEditText.text.toString()))

        //clear the text
        mainActivityEditText.setText("")
    }
    private fun setupAdapter(data: ArrayList<Message>){
        val linearLayoutManager = LinearLayoutManager(this)
        mainActivityRecyclerView.layoutManager = linearLayoutManager
        mainActivityRecyclerView.adapter = MessageAdapter(data) {
            Toast.makeText(this, "${it.text} clicked", Toast.LENGTH_SHORT).show()
        }

        //scroll to bottom
        mainActivityRecyclerView.scrollToPosition(data.size - 1)
    }
    private fun createFirebaseListener(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val toReturn: ArrayList<Message> = ArrayList();

                for(data in dataSnapshot.children){
                    val messageData = data.getValue<Message>(Message::class.java)

                    //unwrap
                    val message = messageData?.let { it } ?: continue

                    toReturn.add(message)
                }

                //sort so newest at bottom
                toReturn.sortBy { message ->
                    message.timestamp
                }

                setupAdapter(toReturn)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                //log error
            }
        }
        databaseReference?.child("messages")?.addValueEventListener(postListener)
    }

}
