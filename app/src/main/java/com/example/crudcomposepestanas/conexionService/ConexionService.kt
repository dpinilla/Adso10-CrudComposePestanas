package com.example.crudcomposepestanas.conexionService

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class ConexionService {

    companion object {
        val supabase = createSupabaseClient(
            supabaseUrl = "https://kyuqwwbyngwkbcsdwibd.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imt5dXF3d2J5bmd3a2Jjc2R3aWJkIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Njk1MzYwMTYsImV4cCI6MjA4NTExMjAxNn0.Jo5jG3vtypP8dwQiZ3eDvGAIw-91Jq0FPEY0eFv_7bA"
        ) {
            install(Postgrest)
        }
    }
}