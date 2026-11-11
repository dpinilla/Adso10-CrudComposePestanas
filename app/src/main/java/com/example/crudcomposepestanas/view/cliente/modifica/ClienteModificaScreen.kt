package com.example.crudcomposepestanas.view.cliente.modifica

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crudcomposepestanas.R
import com.example.crudcomposepestanas.model.ModelCliente
import com.example.crudcomposepestanas.view.Espacio

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ClienteModificaScreen(){
    var cedula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    val clienteModificaViewModel: ClienteModificaViewModel = viewModel()
    val dato by clienteModificaViewModel.dato.collectAsStateWithLifecycle()

    LaunchedEffect(dato) {
        dato?.let{modCliente->
            if(cedula.isBlank()) cedula = modCliente.cedula?: ""
            if(nombre.isBlank()) nombre = modCliente.nombre?: ""
            if(apellido.isBlank()) apellido = modCliente.apellido?: ""
            if(edad.isBlank()) edad = modCliente.edad?.toString()?: ""
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.modificar),
                        Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                actions = {
                    IconButton(
                        onClick = {clienteModificaViewModel.eliminaCliente(cedula)}
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_delete),
                            contentDescription = "${stringResource(R.string.elimina)}"
                        )
                    }

                }
            )
        }
    ) {MyPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(MyPadding)
        ) {
            TextField(
                value = cedula,
                onValueChange = { cedula = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.cedula))}
            )
            Espacio(30)
            TextField(
                value = nombre,
                onValueChange = { nombre = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.nombre))}
            )
            Espacio(30)
            TextField(
                value = apellido,
                onValueChange = { apellido = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.apellido))}
            )
            Espacio(30)
            TextField(
                value = edad,
                onValueChange = { edad = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.edad))}
            )
            Espacio(30)
            Button(
                onClick = {
                    clienteModificaViewModel.modificaCliente(
                        ModelCliente(cedula, nombre, apellido, edad.toInt())
                    )
                },
                Modifier
                    .fillMaxWidth()
            ) {
                Text(stringResource(R.string.modificar))
            }
        }
    }
}