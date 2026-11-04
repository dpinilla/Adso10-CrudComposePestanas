package com.example.crudcomposepestanas.view.cliente.inserta

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudcomposepestanas.conexionService.ConexionCliente
import com.example.crudcomposepestanas.model.ModelCliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InsertaClienteViewModel: ViewModel() {
    val conexionCliente = ConexionCliente()

    fun guardar(data: ModelCliente){
        viewModelScope.launch {
            try{
                conexionCliente.insertaCliente(data)
            }
            catch (e: Exception){
                Log.e("errores", "error $e, nNo se pudo conectar al backend")
            }
        }
    }
}