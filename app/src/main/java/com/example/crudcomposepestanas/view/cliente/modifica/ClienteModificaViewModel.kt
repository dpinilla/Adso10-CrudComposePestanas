package com.example.crudcomposepestanas.view.cliente.modifica

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudcomposepestanas.conexionService.ConexionCliente
import com.example.crudcomposepestanas.model.ModelCliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClienteModificaViewModel(
    argumento: SavedStateHandle
): ViewModel() {
    val cedula: String = checkNotNull(argumento["cedula"])
    private val _dato = MutableStateFlow<ModelCliente?>(null)
    val dato: StateFlow<ModelCliente?> = _dato.asStateFlow()
    val conexionCliente = ConexionCliente()

    init {
        consultaClienteId(cedula)
    }

    fun consultaClienteId(cedula: String){
        viewModelScope.launch {
            try{
                val datos = conexionCliente.consultaClienteId(cedula)
                _dato.value = datos
            }
            catch (e: Exception){
                Log.e("errores", "error $e, nNo se pudo conectar al backend")
            }
        }
    }

    fun modificaCliente(data: ModelCliente){
        viewModelScope.launch {
            try{
                conexionCliente.modificaCliente(data)
            }
            catch (e: Exception){
                Log.e("errores", "error $e, nNo se pudo conectar al backend")
            }
        }
    }
}