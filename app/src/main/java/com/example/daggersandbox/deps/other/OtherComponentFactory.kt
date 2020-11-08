package com.example.daggersandbox.deps.other

import com.example.di.ComponentFactory
import com.example.other.DaggerOtherComponent
import com.example.other.OtherComponent
import com.example.other.OtherDeps

class OtherComponentFactory : ComponentFactory<OtherComponent> {

    override fun create(): OtherComponent {
        return DaggerOtherComponent.builder()
            .otherDeps(
                object : OtherDeps {
                    override fun someString(): String {
                        return "Some String"
                    }
                }
            )
            .build()
    }
}