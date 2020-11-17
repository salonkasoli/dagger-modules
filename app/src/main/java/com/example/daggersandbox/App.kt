package com.example.daggersandbox

import android.app.Application
import com.example.daggersandbox.deps.other.OtherComponentFactory
import com.example.daggersandbox.deps.text.TextComponentFactory
import com.example.di.Injector
import com.example.other.OtherComponent
import com.example.text.TextComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initFeatureComponent()
    }

    private fun initFeatureComponent() {
        Injector.put(OtherComponent::class.java, OtherComponentFactory())
        Injector.put(TextComponent::class.java, TextComponentFactory())
    }
}