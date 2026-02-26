package com.montse.eventpulse.features.auth.domain.repositories

import com.montse.eventpulse.core.util.Resource
import com.montse.eventpulse.features.auth.domain.model.User

interface AuthRepository {
    suspend fun login(username: String, password: String): Resource<User>
}