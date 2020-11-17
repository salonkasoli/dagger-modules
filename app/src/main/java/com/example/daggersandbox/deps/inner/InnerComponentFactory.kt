package com.example.daggersandbox.deps.inner

import com.example.di.ComponentFactory
import com.example.di.FeatureComponent
import com.example.di.Injector
import com.example.inner.DaggerInnerComponent
import com.example.inner.stub.InnerStubComponent
import com.example.other.OtherComponent

class InnerComponentFactory : ComponentFactory<FeatureComponent> {

    override fun create(): FeatureComponent {
        val otherComponent = Injector.get<OtherComponent>(OtherComponent.INJECT_KEY)
        val isInnerStub = otherComponent.isInnerStub()
        return if (!isInnerStub) {
            DaggerInnerComponent.builder()
                .build()
        } else {
            InnerStubComponent()
        }
    }
}