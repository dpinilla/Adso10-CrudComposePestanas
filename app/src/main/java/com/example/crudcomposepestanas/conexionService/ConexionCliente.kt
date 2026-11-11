package com.example.crudcomposepestanas.conexionService

import com.example.crudcomposepestanas.conexionService.ConexionService.Companion.supabase
import com.example.crudcomposepestanas.model.ModelCliente
import io.github.jan.supabase.postgrest.from

class ConexionCliente{
    suspend fun consultaCliente(): List<ModelCliente>{
        return supabase
            .from("cliente_adso_10")
            .select()
            .decodeList<ModelCliente>()
    }

    suspend fun insertaCliente(data: ModelCliente){
        supabase
            .from("cliente_adso_10")
            .insert(data)
    }

    suspend fun consultaClienteId(cedula: String): ModelCliente{
        return supabase
            .from("cliente_adso_10")
            .select(){
                filter {
                    eq("cedula", cedula)
                }
            }
            .decodeSingle<ModelCliente>()
    }

    suspend fun modificaCliente(data: ModelCliente){
        supabase
            .from("cliente_adso_10")
            .update(data) {
            filter {
                eq("cedula", data.cedula!!)
            }
        }
    }

    suspend fun eliminaCliente(cedula:String){
        supabase
            .from("cliente_adso_10")
            .delete {
            filter {
                eq("cedula", cedula)
            }
        }
    }
}