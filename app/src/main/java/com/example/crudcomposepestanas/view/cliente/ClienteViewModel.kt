package com.example.crudcomposepestanas.view.cliente

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudcomposepestanas.conexionService.ConexionCliente
import com.example.crudcomposepestanas.model.ModelCliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClienteViewModel: ViewModel() {
    private val _lista = MutableStateFlow<List<ModelCliente>>(emptyList())
    val listaCliente: StateFlow<List<ModelCliente>> = _lista.asStateFlow()
    val conexionCliente = ConexionCliente()

    fun visualiza(){
        viewModelScope.launch {
            try{
                val datos = conexionCliente.consultaCliente()
                _lista.value = datos
            }
            catch (e: Exception){
                Log.e("errores", "error $e, nNo se pudo conectar al backend")
            }
        }
    }
}