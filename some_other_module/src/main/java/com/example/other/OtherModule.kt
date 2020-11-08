package com.example.other

import com.example.some_other_module_api.OtherRepository
import dagger.Module
import dagger.Provides

@Module
class OtherModule {

    @OtherScope
    @Provides
    fun createRepo(string: String): OtherRepository {
        return OtherRepositoryImpl(string)
    }
}