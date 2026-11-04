package com.example.crudcomposepestanas.view.articulo

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
import com.example.crudcomposepestanas.view.cliente.ClienteViewModel

@Composable
fun ArticuloScreen(
    viewModelArticulo: ArticuloViewModel
){
    val listaArticulo by viewModelArticulo.listaArticulo.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModelArticulo.visualiza()
    }
    Scaffold() {MyPadding->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(MyPadding)
        ) {
            itemsIndexed(listaArticulo){index, articulo->
                Column() { }
            }
        }
    }
}