package com.example.inner

import com.example.di.FeatureComponent
import com.example.inner.api.InnerApi
import dagger.Component

@Component(
    modules = [InnerModule::class]
)
abstract class InnerComponent : FeatureComponent, InnerApi