package com.example.crudcomposepestanas.view.articulo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudcomposepestanas.conexionService.ConexionArticulo
import com.example.crudcomposepestanas.conexionService.ConexionCliente
import com.example.crudcomposepestanas.model.ModelArticulo
import com.example.crudcomposepestanas.model.ModelCliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticuloViewModel: ViewModel() {
    private val _lista = MutableStateFlow<List<ModelArticulo>>(emptyList())
    val listaArticulo: StateFlow<List<ModelArticulo>> = _lista.asStateFlow()
    val conexionArticulo = ConexionArticulo()

    fun visualiza(){
        viewModelScope.launch {
            try{
                val datos = conexionArticulo.consultaArticulo()
                _lista.value = datos
            }
            catch (e: Exception){
                Log.e("errores", "error $e, nNo se pudo conectar al backend")
            }
        }
    }
}