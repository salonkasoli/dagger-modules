package com.example.other

import com.example.di.FeatureComponent
import com.example.some_other_module_api.OtherApi
import dagger.Component

@OtherScope
@Component(
    modules = [OtherModule::class],
    dependencies = [OtherDeps::class]
)
abstract class OtherComponent : FeatureComponent, OtherApi {
    companion object {
        val INJECT_KEY = "other_component"
    }
}