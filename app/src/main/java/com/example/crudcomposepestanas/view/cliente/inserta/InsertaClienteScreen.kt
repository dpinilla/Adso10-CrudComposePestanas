package com.example.crudcomposepestanas.view.cliente.inserta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crudcomposepestanas.R
import com.example.crudcomposepestanas.model.ModelCliente

@Composable
fun InsertaClienteScreen(){
    var cedula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    val insertaViewModel: InsertaClienteViewModel = viewModel()
    Scaffold() {MyPadding->
        Column(
            Modifier
                .fillMaxSize()
                .padding(MyPadding)
        ) {
            TextField(
                value = cedula,
                onValueChange = {cedula = it},
                Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.cedula)) }
            )
            Spacer(
                Modifier
                    .height(30.dp)
            )
            TextField(
                value = nombre,
                onValueChange = {nombre = it},
                Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.nombre)) }
            )
            Spacer(
                Modifier
                    .height(30.dp)
            )
            TextField(
                value = apellido,
                onValueChange = {apellido = it},
                Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.apellido)) }
            )
            Spacer(
                Modifier
                    .height(30.dp)
            )
            TextField(
                value = edad,
                onValueChange = {edad = it},
                Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.edad)) }
            )
            Spacer(
                Modifier
                    .height(30.dp)
            )
            Button(
                onClick = {
                    insertaViewModel.guardar(ModelCliente(cedula,nombre, apellido, edad.toInt()))
                },
                Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(stringResource(R.string.guardar))
            }
        }
    }
}