package com.rmd.jetsupintro.datasource

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.FilterOperator
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val supabaseClient: SupabaseClient
) {
    suspend fun deleteById(userId : Int){
        supabaseClient.postgrest["users"].delete {
            filter("id", FilterOperator.EQ, userId)
        }
    }
}

sealed class ApiResult<out R> {
    data class Success<out R>(val data: R): ApiResult<R>()
    data class Error(val message: String?): ApiResult<Nothing>()
    data object Loading : ApiResult<Nothing>()
}