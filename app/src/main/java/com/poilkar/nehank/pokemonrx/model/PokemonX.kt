package com.poilkar.nehank.pokemonrx.model


import com.google.gson.annotations.SerializedName

data class PokemonX(
    @SerializedName("avg_spawns")
    val avgSpawns: Int ?= null,
    val candy: String ?= null,
    @SerializedName("candy_count")
    val candyCount: Int ?= null,
    val egg: String ?= null,
    val height: String ?= null,
    val id: Int ?= null,
    val img: String ?= null,
    val multipliers: List<Double> ?= null,
    val name: String ?= null,
    @SerializedName("next_evolution")
    val nextEvolution: List<NextEvolution> ?= null,
    val num: String ?= null,
    @SerializedName("prev_evolution")
    val prevEvolution: List<PrevEvolution> ?= null,
    @SerializedName("spawn_chance")
    val spawnChance: Double ?= null,
    @SerializedName("spawn_time")
    val spawnTime: String ?= null,
    val type: List<String> ?= null,
    val weaknesses: List<String> ?= null,
    val weight: String ?= null
)