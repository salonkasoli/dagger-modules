package com.example.other

import com.example.di.FeatureComponent
import com.example.some_other_module_api.OtherRepository
import dagger.Component

@OtherScope
@Component(
    modules = [OtherModule::class],
    dependencies = [OtherDeps::class]
)
abstract class OtherComponent : FeatureComponent {

    abstract fun repo(): OtherRepository
}