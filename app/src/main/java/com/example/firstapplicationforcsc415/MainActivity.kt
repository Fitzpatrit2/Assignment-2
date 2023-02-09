package com.example.firstapplicationforcsc415


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)


        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = mutableListOf<Godzilla>()

        for (i in 0..30) {
            characters.add(createCharacters())
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter
    }

    private fun createCharacters() = Godzilla (
        name = "Godzilla",
        heightof = 100,
        image = R.drawable.godzilla_image,
        firstAppearance = "1954",
        powers = "Tail, Atomic Breath",


    )

}