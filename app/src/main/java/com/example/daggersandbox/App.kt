package com.example.daggersandbox

import android.app.Application
import com.example.daggersandbox.deps.inner.InnerComponentFactory
import com.example.daggersandbox.deps.other.OtherComponentFactory
import com.example.daggersandbox.deps.text.TextComponentFactory
import com.example.di.Injector
import com.example.inner.InnerComponent
import com.example.inner.api.InnerApi
import com.example.other.OtherComponent
import com.example.text.TextComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initFeatureComponent()
    }

    private fun initFeatureComponent() {
        Injector.put(OtherComponent.INJECT_KEY, OtherComponentFactory())
        Injector.put(TextComponent.INJECT_KEY, TextComponentFactory())
        Injector.put(InnerComponent.INJECT_KEY, InnerComponentFactory())
    }
}