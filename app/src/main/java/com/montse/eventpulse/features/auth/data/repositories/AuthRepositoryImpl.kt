package com.montse.eventpulse.features.auth.data.repositories

import android.content.Context
import android.content.SharedPreferences
import com.montse.eventpulse.core.util.Constants
import com.montse.eventpulse.core.util.Resource
import com.montse.eventpulse.features.auth.data.remote.AuthApiService
import com.montse.eventpulse.features.auth.data.remote.LoginRequestDto
import com.montse.eventpulse.features.auth.domain.model.User
import com.montse.eventpulse.features.auth.domain.repositories.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApiService,
    @ApplicationContext private val context: Context // Para guardar el token
) : AuthRepository {

    override suspend fun login(username: String, password: String): Resource<User> {
        return try {
            val response = api.login(LoginRequestDto(username, password))

            val prefs: SharedPreferences = context.getSharedPreferences(Constants.PREFERENCES_NAME, Context.MODE_PRIVATE)
            prefs.edit().putString(Constants.KEY_JWT_TOKEN, response.token).apply()

            // 2. Convertir DTO a Modelo de Dominio
            val user = User(
                id = response.usuario.id,
                username = response.usuario.username,
                name = response.usuario.nombre,
                role = response.usuario.rol,
                token = response.token
            )
            Resource.Success(user)

        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Error de servidor")
        } catch (e: IOException) {
            Resource.Error("No hay conexión a internet")
        } catch (e: Exception) {
            Resource.Error("Error desconocido: ${e.message}")
        }
    }
}