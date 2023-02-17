package com.example.firstapplicationforcsc415.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplicationforcsc415.CharacterAdapter
import com.example.firstapplicationforcsc415.Godzilla
import com.example.firstapplicationforcsc415.R


class GodzillaListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_godzilla_list, container, false)

       // if (arguments != null){
         //   val name = requireArguments().getString("name")
           // val heightof = requireArguments().getString("heightof")
          //  val image = requireArguments().getString("image")
          //  val firstApperance = requireArguments().getString("firstApperance")
          //  val powers = requireArguments().getString("powers")

           //  view.findViewById<TextView>(R.id.character_fragement)
           //
        //Glide.with(this).load(fragment_character).into(view.findViewById(R.id.godzilla_images))
       // }
        val recyclerView = view.findViewById<RecyclerView>(R.id.fragementrecycler)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = mutableListOf<Godzilla>()

        for (i in 0..30) {
            characters.add(createCharacters())
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }

    private fun createCharacters() = Godzilla(
        name = "Godzilla",
        heightof = 100,
        image = R.drawable.godzilla_image,
        firstAppearance = "1954",
        powers = "Tail, Atomic Breath",


        )

}