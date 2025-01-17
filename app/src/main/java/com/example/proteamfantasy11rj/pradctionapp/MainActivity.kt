package com.example.proteamfantasy11rj.pradctionapp


import android.content.Intent
import androidx.activity.enableEdgeToEdge

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proteamfantasy11rj.pradctionapp.Fragment1.second_Activity
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonFragment:Button


    private lateinit var recyclerView: RecyclerView
    private lateinit var database: DatabaseReference
    private val questions = mutableListOf<Question>()
    private val questionIds = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

buttonFragment=findViewById(R.id.button1)
buttonFragment.setOnClickListener {
    val intent= Intent(this,second_Activity::class.java)
    startActivity(intent)
}

                recyclerView = findViewById(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)

                database = FirebaseDatabase.getInstance().getReference("questions")

                loadQuestions()
            }



    private fun loadQuestions() {
                database.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        questions.clear()
                        questionIds.clear()

                        for (questionSnapshot in snapshot.children) {
                            val question = questionSnapshot.getValue(Question::class.java)
                            val questionId = questionSnapshot.key
                            if (question != null && questionId != null) {
                                questions.add(question)
                                questionIds.add(questionId)
                            }
                        }

                        recyclerView.adapter = QuestionAdapter(questions, questionIds)
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}