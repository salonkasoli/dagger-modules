package com.example.text

import com.example.di.FeatureComponent
import dagger.Component

@Component(
    dependencies = [TextDeps::class]
)
abstract class TextComponent : FeatureComponent {

    companion object {
        val INJECT_KEY = "text_component"
    }

    abstract fun inject(activity: TextActivity)
}