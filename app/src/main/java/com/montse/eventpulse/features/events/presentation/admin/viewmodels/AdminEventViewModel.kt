package com.montse.eventpulse.features.events.presentation.admin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montse.eventpulse.features.events.domain.usecases.admin.CreateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminEventViewModel @Inject constructor(
    private val createTaskUseCase: CreateTaskUseCase
) : ViewModel() {

    private val _isCreating = MutableStateFlow(false)
    val isCreating: StateFlow<Boolean> = _isCreating.asStateFlow()

    fun createNewTask(eventId: String, title: String, desc: String) {
        viewModelScope.launch {
            _isCreating.value = true
            createTaskUseCase(eventId, title, desc)
            _isCreating.value = false
        }
    }
}