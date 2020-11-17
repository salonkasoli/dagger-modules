package com.example.inner

import com.example.inner.api.InnerRepository
import javax.inject.Inject

@InnerScope
class InnerRepositoryImpl @Inject constructor() : InnerRepository {

    override fun getString(): String {
        return "This is a default inner module"
    }
}