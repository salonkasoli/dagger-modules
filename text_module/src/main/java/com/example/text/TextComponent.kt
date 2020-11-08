package com.example.text

import com.example.di.FeatureComponent
import dagger.Component

@Component(
    dependencies = [TextDeps::class]
)
abstract class TextComponent : FeatureComponent {

    abstract fun inject(activity: TextActivity)
}