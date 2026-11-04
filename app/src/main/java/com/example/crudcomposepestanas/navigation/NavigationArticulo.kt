package com.example.crudcomposepestanas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crudcomposepestanas.view.articulo.ArticuloScreen
import com.example.crudcomposepestanas.view.articulo.ArticuloViewModel
import com.example.crudcomposepestanas.view.cliente.ClienteScreen

@Composable
fun NavegationArticulo(
    viewModelArticulo: ArticuloViewModel
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "articulo") {
        composable("articulo") {
            ArticuloScreen(
                viewModelArticulo
            )
        }

    }
}