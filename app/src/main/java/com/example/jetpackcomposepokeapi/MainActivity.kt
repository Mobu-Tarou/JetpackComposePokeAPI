package com.example.jetpackcomposepokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposepokeapi.ui.theme.JetpackComposePokeAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokeAPITheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenRoute.PokemonListScreen.route
                ) {
                    composable(route = ScreenRoute.PokemonListScreen.route) {
                        // TODO: ポケモン一覧画面のComposable
                    }
                    composable(
                        route = "${ScreenRoute.PokemonDetailScreen.route}/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") { type = NavType.IntType },
                            navArgument("pokemonName") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        // ポケモン一覧画面からポケモン詳細画面へ渡す引数
                        val dominantColor = remember {
                            val color = backStackEntry.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            backStackEntry.arguments?.getString("pokemonName")
                        }
                        // TODO: ポケモン詳細画面のComposable
                    }
                }
            }
        }
    }
}