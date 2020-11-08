package com.example.other

import com.example.some_other_module_api.OtherRepository
import javax.inject.Inject

@OtherScope
class OtherRepositoryImpl @Inject constructor(
    private val string: String
) : OtherRepository {

    override fun getSomeString(): String {
        return string
    }

}