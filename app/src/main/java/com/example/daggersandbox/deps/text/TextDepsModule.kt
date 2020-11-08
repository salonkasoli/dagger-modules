package com.example.daggersandbox.deps.text

import com.example.text.TextDeps
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface TextDepsModule {
    @Binds
    @Singleton
    fun textDeps(textDepsImpl: TextDepsImpl) : TextDeps
}