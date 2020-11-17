package com.example.di

/**
 * Синглтон Dependency container.
 */
// TODO sync this and typesafety
object Injector {

    /**
     * Уже созданные компоненты
     */
    private val components = HashMap<Any, Component>()

    /**
     * Фабрики, с помощью которых создаются компоненты
     */
    private val factories = HashMap<Any, ComponentFactory<out Component>>()

    /**
     * Добавить фабрику компонента. Компонент будет создан в момент, когда он понадобится
     * в первый раз и затем закэширован.
     */
    fun put(key: Any, factory: ComponentFactory<out Component>) {
        factories[key] = factory
    }

    /**
     * Получить компонент (или создать новый, если еще не был создан).
     */
    fun <T> get(key: Any): T {
        val component = components[key]
        if (component != null) {
            return component as T
        }

        val factory = factories[key]
            ?: throw IllegalArgumentException("There is no factory for key = $key")

        val newComponent = factory.create()
        components[key] = newComponent
        return newComponent as T
    }
}