package com.example.inner.stub

import com.example.inner.api.InnerRepository

class InnerStubRepository : InnerRepository {
    override fun getString(): String {
        return "This is a stab string"
    }
}