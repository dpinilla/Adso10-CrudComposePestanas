package com.example.crudcomposepestanas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crudcomposepestanas.view.ClienteScreen
import com.example.crudcomposepestanas.view.ClienteViewModel

@Composable
fun NavegationCliente(
    viewModelCliente: ClienteViewModel
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "cliente") {
        composable("cliente") {
            ClienteScreen(
                viewModelCliente
            )
        }

    }
}