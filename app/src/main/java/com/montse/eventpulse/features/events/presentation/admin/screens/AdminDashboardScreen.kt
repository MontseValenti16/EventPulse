package com.montse.eventpulse.features.events.presentation.admin.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montse.eventpulse.features.events.presentation.admin.components.CreateTaskDialog
import com.montse.eventpulse.features.events.presentation.admin.viewmodels.AdminEventViewModel

@Composable
fun AdminDashboardScreen(
    eventId: String,
    viewModel: AdminEventViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val isCreating by viewModel.isCreating.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, "Crear Tarea")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            Text("Panel Admin - Evento: $eventId")
            if (isCreating) LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        if (showDialog) {
            CreateTaskDialog(
                onDismiss = { showDialog = false },
                onConfirm = { t, d ->
                    viewModel.createNewTask(eventId, t, d)
                    showDialog = false
                }
            )
        }
    }
}