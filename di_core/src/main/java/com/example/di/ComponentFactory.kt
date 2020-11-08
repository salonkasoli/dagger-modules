package com.example.di

/**
 * Фабрика компонента.
 * ВАЖНО!
 * Фабрика создается при создании App, поэтому все зависимости она должна получать через [Injector]
 * в методе create.
 */
interface ComponentFactory<C : Component> {
    fun create(): C
}