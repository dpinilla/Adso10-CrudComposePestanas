package com.example.crudcomposepestanas.conexionService

import com.example.crudcomposepestanas.conexionService.ConexionService.Companion.supabase
import com.example.crudcomposepestanas.model.ModelArticulo
import com.example.crudcomposepestanas.model.ModelCliente
import io.github.jan.supabase.postgrest.from

class ConexionArticulo{
    suspend fun consultaArticulo(): List<ModelArticulo>{
        return supabase
            .from("articulo_adso_10")
            .select()
            .decodeList<ModelArticulo>()
    }
}