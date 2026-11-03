package com.example.crudcomposepestanas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ClienteScreen(
    viewModelCliente: ClienteViewModel
){
    val listaCliente by viewModelCliente.listaCliente.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModelCliente.visualiza()
    }
    Scaffold() {MyPadding->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(MyPadding)
        ) {
            itemsIndexed(listaCliente){index, cliente->
                Column() { }
            }
        }
    }
}