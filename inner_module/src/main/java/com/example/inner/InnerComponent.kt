package com.example.inner

import com.example.di.FeatureComponent
import com.example.inner.api.InnerApi
import dagger.Component

@InnerScope
@Component(
    modules = [InnerModule::class]
)
abstract class InnerComponent : FeatureComponent, InnerApi {
    companion object {
        val INJECT_KEY = "innerComponent"
    }
}