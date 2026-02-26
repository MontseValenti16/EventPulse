package com.montse.eventpulse.features.auth.data.di

import com.montse.eventpulse.core.di.PublicClient
import com.montse.eventpulse.core.util.Constants
import com.montse.eventpulse.features.auth.data.remote.AuthApiService
import com.montse.eventpulse.features.auth.data.repositories.AuthRepositoryImpl
import com.montse.eventpulse.features.auth.domain.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApiService(

        @PublicClient okHttpClient: OkHttpClient
    ): AuthApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository {
        return repository
    }
}