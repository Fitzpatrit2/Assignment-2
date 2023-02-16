package com.example.firstapplicationforcsc415

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapplicationforcsc415.UI.CharacterFragment
import com.example.firstapplicationforcsc415.UI.GodzillaListFragment

class CharacterAdapter(private val characters: List<GodzillaCharacters>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.godzilla_card_view, parent, false)


        return CharacterViewHolder(view) {
            val character = characters[it]

            val bundle = bundleOf(
                "name" to character.name,
                "heightof" to character.heightof,
                "image" to character.image,
                "firstAppearance" to character.firstAppearance,
                "powers" to character.powers
            )

            val GodzillaDetailListFragment = CharacterFragment()
            GodzillaDetailListFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view_tag, GodzillaDetailListFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        Glide
            .with(holder.itemView.context)
            .load(character.image)
            .into(holder.characterImage)
        holder.characterName.text = character.name
        holder.characterHeight.text = character.heightof.toString()
        holder.characterfirstAppearance.text = character.firstAppearance
        holder.characterPowers.text = character.powers

    }

    inner class CharacterViewHolder(itemView: View, private val onItemClick: (adapterPosition: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.image)
        val characterName: TextView = itemView.findViewById(R.id.name)
        val characterHeight: TextView = itemView.findViewById(R.id.height)
        val characterfirstAppearance: TextView = itemView.findViewById(R.id.firstAppearance)
        val characterPowers: TextView = itemView.findViewById(R.id.Powers)
        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}

