package com.poilkar.nehank.pokemonrx

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poilkar.nehank.pokemonrx.model.PokemonX
import kotlinx.android.synthetic.main.row_pokemon_list.view.*

class PokemonAdapter(val context: Context, val pokemonList: ArrayList<PokemonX>, val type: String
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>(){

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_pokemon_list,parent,false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.apply {


            when(type){
                TYPE_ELECTRIC -> {
                    ivPokemonType.setImageResource(R.drawable.ic_electric)
                }
                TYPE_GRASS -> {
                    ivPokemonType.setImageResource(R.drawable.ic_leaf)
                }
                TYPE_WATER -> {
                    ivPokemonType.setImageResource(R.drawable.ic_water)
                }
                TYPE_FIRE -> {
                    ivPokemonType.setImageResource(R.drawable.ic_fire)
                }
                TYPE_SPECIAL -> {
                    ivPokemonType.setImageResource(R.drawable.ic_special)
                }

            }


            tv_PokemonName.text = pokemon.name
            tvPokemonType.text = pokemon.type?.joinToString(",") ?: ""
            Glide.with(context)
                .load(pokemon.img)
                .into(ivPokemonImage)
        }
    }
}