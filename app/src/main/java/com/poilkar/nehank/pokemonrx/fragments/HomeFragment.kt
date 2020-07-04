package com.poilkar.nehank.pokemonrx.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.poilkar.nehank.pokemonrx.*
import com.poilkar.nehank.pokemonrx.model.PokemonX
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var pokemonList : ArrayList<PokemonX>
    lateinit var adapter: PokemonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setClickListeners()
    }

    private fun setClickListeners() {
        chipElectric.setOnClickListener {
            getElectricTypePokemon(TYPE_ELECTRIC)
        }

        chipGrass.setOnClickListener {
            getElectricTypePokemon(TYPE_GRASS)
        }

        chipWater.setOnClickListener {
            getElectricTypePokemon(TYPE_WATER)
        }

        chipFire.setOnClickListener {
            getElectricTypePokemon(TYPE_FIRE)
        }

        chipSpecial.setOnClickListener {
            getElectricTypePokemon(TYPE_SPECIAL)
        }
    }

    private fun init() {
        firebaseFirestore = FirebaseFirestore.getInstance()
        pokemonList = ArrayList()
        getElectricTypePokemon(TYPE_ELECTRIC)
    }

    private fun getElectricTypePokemon(type: String = "type_electric" ) {
        firebaseFirestore.collection(type)
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful){

                    if(task.result != null){
                        pokemonList.clear()
                        pokemonList = task.result?.toObjects(PokemonX::class.java) as ArrayList<PokemonX>
                        adapter = PokemonAdapter(this.requireContext(), pokemonList, type)
                        rvPokemon.layoutManager = LinearLayoutManager(this.requireContext(),LinearLayoutManager.VERTICAL,false)
                        rvPokemon.adapter = adapter
                    }



                }else{
                    Log.d("TAG", "getElectricTypePokemon: Error")
                }
            }
    }

}