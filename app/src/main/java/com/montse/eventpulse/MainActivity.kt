package com.montse.eventpulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.montse.eventpulse.core.navigation.AppNavigation
import com.montse.eventpulse.ui.theme.EventPulseTheme // O el nombre de tu tema si es diferente
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // <--- ¡VITAL! Sin esto, la app se cierra al abrir
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí envolvemos la navegación con el tema
            EventPulseTheme {
                AppNavigation() // <--- Aquí llamamos a tu mapa de rutas
            }
        }
    }
}