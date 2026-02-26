package com.montse.eventpulse.features.events.data.di

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import com.montse.eventpulse.core.database.AppDatabase
import com.montse.eventpulse.features.events.data.local.EventDao
import com.montse.eventpulse.features.events.data.remote.EventApiService
import com.montse.eventpulse.features.events.data.remote.EventSocketService
import com.montse.eventpulse.features.events.data.repositories.EventRepositoryImpl
import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EventsModule {

    @Provides
    @Singleton
    fun provideEventDao(db: AppDatabase): EventDao = db.eventDao()

    @Provides
    @Singleton
    fun provideEventApiService(retrofit: Retrofit): EventApiService =
        retrofit.create(EventApiService::class.java)

    @Provides
    @Singleton
    fun provideEventSocketService(client: HttpClient): EventSocketService =
        EventSocketService(client)

    @Provides
    @Singleton
    fun provideEventRepository(
        api: EventApiService,
        socket: EventSocketService,
        dao: EventDao
    ): EventRepository = EventRepositoryImpl(api, socket, dao)
}