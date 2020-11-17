package com.example.daggersandbox.deps.text

import com.example.di.ComponentFactory
import com.example.di.Injector
import com.example.inner.InnerComponent
import com.example.inner.api.InnerApi
import com.example.text.DaggerTextComponent
import com.example.text.TextComponent

class TextComponentFactory : ComponentFactory<TextComponent> {

    override fun create(): TextComponent {
        val innerApi = Injector.get<InnerApi>(InnerComponent.INJECT_KEY)
        return DaggerTextComponent.builder()
            .textDeps(TextDepsImpl(innerApi.getRepo()))
            .build()
    }
}