package com.rmd.jetsupintro.data.datasource

import io.github.jan.supabase.SupabaseClient
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val client: SupabaseClient
) {
}