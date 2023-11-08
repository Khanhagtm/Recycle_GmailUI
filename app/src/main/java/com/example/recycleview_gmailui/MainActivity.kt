package com.example.recycleview_gmailui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    private val faker = Faker(Locale.UK)
    private val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)

    @SuppressLint("InflateParams", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emails = generateEmails(20)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emails)
    }

    private fun generateEmails(count: Int): List<Email> {
        val emails: MutableList<Email> = ArrayList()
        for (i in 0 until count) {
            val name = faker.name().fullName()
            val time = timeFormat.format(faker.date().birthday())
            val subject = faker.lorem().sentence()
            emails.add(Email(name, time, subject))
        }
        return emails
    }
}