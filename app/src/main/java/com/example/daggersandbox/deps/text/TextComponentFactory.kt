package com.example.daggersandbox.deps.text

import com.example.di.ComponentFactory
import com.example.di.Injector
import com.example.text.DaggerTextComponent
import com.example.text.TextComponent

class TextComponentFactory : ComponentFactory<TextComponent> {

    override fun create(): TextComponent {
        return DaggerTextComponent.builder()
            .textDeps(Injector.get(TextDepsComponent::class.java).getDeps())
            .build()
    }
}