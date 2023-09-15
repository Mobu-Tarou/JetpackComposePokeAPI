package com.example.jetpackcomposepokeapi

sealed class ScreenRoute(val route: String) {
    object PokemonListScreen : ScreenRoute("pokemon_list_screen")
    object PokemonDetailScreen : ScreenRoute("pokemon_detail_screen")
}