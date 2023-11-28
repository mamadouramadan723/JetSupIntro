package com.rmd.jetsupintro

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var supabaseUrl : String = ""
    private var supabaseKey : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supabaseUrl = getString(R.string.URL)
        supabaseKey = getString(R.string.KEY)

        getData()
        setContent {
        }
    }

    private fun getData() {
        lifecycleScope.launch {
            val client = getClient()
            val supabaseResponse = client.postgrest["users"].select()
            val data = supabaseResponse.decodeList<User>()
            Log.e("Response", data.toString())
        }
    }

    private fun getClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = supabaseUrl,
            supabaseKey = supabaseKey
        ) {
            install(Postgrest)
        }
    }

    @Serializable
    data class User(
        val id: Int = 0,
        val firstName: String = "",
        val lastName: String = "",
        val email: String = ""

    )
}

