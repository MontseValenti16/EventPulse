package com.montse.eventpulse.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiEndpoint

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WebSocketEndpoint

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthenticatedClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PublicClient