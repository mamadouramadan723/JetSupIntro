package com.rmd.jetsupintro.di

import com.rmd.jetsupintro.ui.profile.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UserModule {

    @Provides
    fun provideUserViewModel() : UserViewModel{
        return UserViewModel()
    }
}