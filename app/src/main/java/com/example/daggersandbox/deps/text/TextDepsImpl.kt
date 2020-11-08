package com.example.daggersandbox.deps.text

import com.example.some_other_module_api.OtherRepository
import com.example.text.TextDeps
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextDepsImpl @Inject constructor(
    private val otherRepository: OtherRepository
) : TextDeps {

    override fun getText(): String {
        return otherRepository.getSomeString()
    }
}