package com.example.crudcomposepestanas.conexionService

import com.example.crudcomposepestanas.conexionService.ConexionService.Companion.supabase
import com.example.crudcomposepestanas.model.ModelCliente
import io.github.jan.supabase.postgrest.from

class ConexionCliente{
    suspend fun consultaCliente(): List<ModelCliente>{
        return supabase
            .from("clienteadso10")
            .select()
            .decodeList<ModelCliente>()
    }
}