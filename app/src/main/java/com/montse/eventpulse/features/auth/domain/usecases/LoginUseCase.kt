package com.montse.eventpulse.features.auth.domain.usecases

import com.montse.eventpulse.core.util.Resource
import com.montse.eventpulse.features.auth.domain.model.User
import com.montse.eventpulse.features.auth.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): Resource<User> {
        if (username.isBlank() || password.isBlank()) {
            return Resource.Error("Por favor llena todos los campos")
        }
        return repository.login(username, password)
    }
}