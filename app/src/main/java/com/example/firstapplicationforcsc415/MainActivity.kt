package com.example.firstapplicationforcsc415


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplicationforcsc415.UI.GodzillaListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
             add(R.id.fragment_container_view_tag, GodzillaListFragment())
                addToBackStack(null)
         }


    }

    private fun createCharacters() = GodzillaCharacters (
        name = "Godzilla",
        heightof = 100,
        image = R.drawable.godzilla_image,
        firstAppearance = "1954",
        powers = "Tail, Atomic Breath",

    )

}