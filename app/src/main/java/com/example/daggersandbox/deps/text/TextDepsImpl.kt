package com.example.daggersandbox.deps.text

import com.example.inner.api.InnerRepository
import com.example.text.TextDeps

class TextDepsImpl constructor(
    private val innerRepository: InnerRepository
) : TextDeps {

    override fun getText(): String {
        return innerRepository.getString()
    }
}