package com.montse.eventpulse.features.events.presentation.staff.viewmodels

import androidx.lifecycle.*
import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import com.montse.eventpulse.features.events.domain.usecases.shared.GetEventTasksUseCase
import com.montse.eventpulse.features.events.presentation.viewmodels.EventState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StaffEventViewModel @Inject constructor(
    private val getEventTasksUseCase: GetEventTasksUseCase,
    private val repository: EventRepository
) : ViewModel() {

    // Cambiamos mutableStateOf por MutableStateFlow
    private val _state = MutableStateFlow(EventState())
    val state: StateFlow<EventState> = _state.asStateFlow()

    fun connectToEvent(eventId: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            // 1. Cargar tareas iniciales
            getEventTasksUseCase(eventId).collect { initialTasks ->
                _state.update { it.copy(tasks = initialTasks, isLoading = false) }
            }

            // 2. Escuchar cambios en vivo (WebSockets)
            repository.observeRealTimeTasks(eventId).collect { updatedTask ->
                _state.update { currentState ->
                    val newList = currentState.tasks.toMutableList()
                    val index = newList.indexOfFirst { it.id == updatedTask.id }
                    if (index != -1) newList[index] = updatedTask else newList.add(updatedTask)
                    currentState.copy(tasks = newList)
                }
            }
        }
    }
}