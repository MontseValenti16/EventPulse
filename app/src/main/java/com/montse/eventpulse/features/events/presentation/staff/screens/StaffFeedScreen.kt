package com.montse.eventpulse.features.events.presentation.staff.screens // Asegúrate de tener tu package arriba

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // 🌟 MÁGIA 1: Para que "items" funcione en LazyColumn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue // 🌟 MÁGIA 2: Para que la palabra "by" funcione sin error
import androidx.compose.ui.Modifier // 🌟 MÁGIA 3: Para usar Modifier directo
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montse.eventpulse.features.events.presentation.staff.components.TaskCard
import com.montse.eventpulse.features.events.presentation.staff.viewmodels.StaffEventViewModel

@Composable
fun StaffFeedScreen(
    eventId: String,
    viewModel: StaffEventViewModel = hiltViewModel()
) {
    // El "by" ya no debería marcar error gracias al import de getValue
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(eventId) {
        viewModel.connectToEvent(eventId)
    }

    if (uiState.isLoading) {
        // Usamos Modifier directo más limpio
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }

    LazyColumn {
        // El "items" ya no debería marcar error
        items(uiState.tasks) { task ->
            TaskCard(task = task)
        }
    }
}