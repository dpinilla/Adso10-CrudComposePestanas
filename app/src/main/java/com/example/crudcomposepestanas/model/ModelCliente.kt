package com.example.crudcomposepestanas.model

import kotlinx.serialization.Serializable

@Serializable
data class ModelCliente(
    val cedula: String? = null,
    val nombre: String? = null,
    val apellido: String? = null,
    val edad: Int? = null
)