package com.example.daggersandbox.deps.text

import com.example.di.ComponentFactory
import com.example.di.Injector
import com.example.other.OtherComponent
import com.example.text.DaggerTextComponent
import com.example.text.TextComponent

class TextComponentFactory : ComponentFactory<TextComponent> {

    override fun create(): TextComponent {
        val otherComponent = Injector.get(OtherComponent::class.java)
        return DaggerTextComponent.builder()
            .textDeps(TextDepsImpl(otherComponent.otherRepository()))
            .build()
    }
}