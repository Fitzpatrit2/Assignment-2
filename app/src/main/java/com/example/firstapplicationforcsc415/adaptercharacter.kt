package com.example.firstapplicationforcsc415
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characters: List<Godzilla>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.godzilla_card_view, parent, false)
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterImage.setImageResource(character.image)
        holder.characterName.text = character.name
        holder.characterHeight.text = character.heightof.toString()
        holder.characterfirstAppearance.text = character.firstAppearance
        holder.characterPowers.text = character.powers

    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.image)
        val characterName: TextView = itemView.findViewById(R.id.name)
        val characterHeight: TextView = itemView.findViewById(R.id.height)
        val characterfirstAppearance: TextView = itemView.findViewById(R.id.firstAppearance)
        val characterPowers: TextView = itemView.findViewById(R.id.Powers)

    }
}

