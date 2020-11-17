package com.example.inner

import com.example.inner.api.InnerRepository
import dagger.Binds
import dagger.Module

@Module
interface InnerModule {

    @Binds
    fun repository(repo: InnerRepositoryImpl): InnerRepository
}