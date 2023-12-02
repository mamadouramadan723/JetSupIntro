package com.rmd.jetsupintro.di

import com.rmd.jetsupintro.BuildConfig
import com.rmd.jetsupintro.datasource.UserDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SupabaseModule {

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = BuildConfig.SUPABASE_URL,
            supabaseKey = BuildConfig.SECRET
        ) {
            install(Postgrest)
        }
    }

    @Provides
    @Singleton
    fun provideUserDataSource(client: SupabaseClient): UserDataSource {
        return UserDataSource(client)
    }
}