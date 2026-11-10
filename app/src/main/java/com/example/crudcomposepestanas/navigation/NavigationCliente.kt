package com.example.crudcomposepestanas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.crudcomposepestanas.view.cliente.ClienteScreen
import com.example.crudcomposepestanas.view.cliente.ClienteViewModel
import com.example.crudcomposepestanas.view.cliente.inserta.InsertaClienteScreen
import com.example.crudcomposepestanas.view.cliente.modifica.ClienteModificaScreen

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
                viewModelCliente,
                onGoInsertar = {navController.navigate("insertarCliente")},
                onGoModificar = { cedula->
                    navController.navigate("modificaCliente/$cedula")

                }
            )
        }
        composable(
            "insertarCliente"
        ) {
            InsertaClienteScreen()
        }
        composable(
            "modificaCliente/{cedula}",
            listOf(navArgument("cedula"){
                                type = NavType.StringType}
            )){
            ClienteModificaScreen()
            }
    }
}