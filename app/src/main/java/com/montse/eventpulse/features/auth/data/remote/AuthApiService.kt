package com.montse.eventpulse.features.auth.data.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequestDto): LoginResponseDto
}

// Modelos para el JSON (DTOs)
data class LoginRequestDto(
    @SerializedName("nombre_usuario") val username: String,
    @SerializedName("password_hash") val password: String
)

data class LoginResponseDto(
    val token: String,
    val usuario: UserDto
)

data class UserDto(
    val id: String,
    @SerializedName("nombre_usuario") val username: String,
    val nombre: String,
    val rol: String
)