package com.example.crudcomposepestanas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.crudcomposepestanas.navigation.NavegationArticulo
import com.example.crudcomposepestanas.navigation.NavegationCliente
import com.example.crudcomposepestanas.ui.theme.CrudComposePestanasTheme
import com.example.crudcomposepestanas.view.articulo.ArticuloViewModel
import com.example.crudcomposepestanas.view.cliente.ClienteViewModel

class MainActivity : ComponentActivity() {
    val viewModelCliente: ClienteViewModel by viewModels()
    val viewModelArticulo: ArticuloViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrudComposePestanasTheme {
                //NavegationCliente(viewModelCliente = viewModelCliente)
                CrudComposePestanasApp(
                    viewModelCliente,
                    viewModelArticulo
                )
            }
        }
    }
}

@Composable
fun CrudComposePestanasApp(
    viewModelCliente: ClienteViewModel,
    viewModelArticulo: ArticuloViewModel
) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.CLIENTE) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        when(currentDestination){
            AppDestinations.CLIENTE-> NavegationCliente(viewModelCliente = viewModelCliente)
            AppDestinations.ARTICULO-> NavegationArticulo(viewModelArticulo = viewModelArticulo)
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    CLIENTE("Cliente", R.drawable.ic_cliente),
    ARTICULO("Articulo", R.drawable.ic_articulo)
}
