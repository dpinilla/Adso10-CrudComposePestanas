package com.example.crudcomposepestanas.model

import kotlinx.serialization.Serializable

@Serializable

data class ModelArticulo(
    val codigo: String? = null,
    val nombre: String? = null,
    val precio: Double? = null,
    val cantidad: Int? = null
)