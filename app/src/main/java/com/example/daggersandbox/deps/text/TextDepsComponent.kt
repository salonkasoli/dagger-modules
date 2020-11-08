package com.example.daggersandbox.deps.text

import com.example.di.ComponentFactory
import com.example.di.DepsComponent
import com.example.di.Injector
import com.example.other.OtherComponent
import com.example.some_other_module_api.OtherRepository
import com.example.text.TextDeps
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [OtherRepository::class],
    modules = [TextDepsModule::class]
)
abstract class TextDepsComponent : DepsComponent {

    abstract fun getDeps(): TextDeps

    class Factory : ComponentFactory<TextDepsComponent> {

        override fun create(): TextDepsComponent {
            return DaggerTextDepsComponent.builder()
                .otherRepository(Injector.get(OtherComponent::class.java).repo())
                .build()
        }
    }
}