package com.montse.eventpulse.features.events.presentation.admin.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CreateTaskDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Nueva Tarea Staff", style = MaterialTheme.typography.titleLarge)
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Título") })
                OutlinedTextField(value = desc, onValueChange = { desc = it }, label = { Text("Descripción") })
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = onDismiss) { Text("Cancelar") }
                    Button(onClick = { onConfirm(title, desc) }, enabled = title.isNotBlank()) { Text("Crear") }
                }
            }
        }
    }
}