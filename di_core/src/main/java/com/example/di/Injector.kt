package com.example.di

/**
 * Синглтон Dependency container.
 */
// TODO sync this
object Injector {

    /**
     * Уже созданные компоненты
     */
    private val components = HashMap<Class<out Component>, Component>()

    /**
     * Фабрики, с помощью которых создаются компоненты
     */
    private val factories = HashMap<Class<out Component>, ComponentFactory<out Component>>()

    /**
     * Добавить фабрику компонента. Компонент будет создан в момент, когда он понадобится
     * в первый раз и затем закэширован.
     */
    fun <T : Component> put(clazz: Class<T>, factory: ComponentFactory<T>) {
        factories[clazz] = factory
    }

    /**
     * Получить компонент (или создать новый, если еще не был создан).
     */
    fun <T : Component> get(clazz: Class<T>): T {
        val component = components[clazz]
        if (component != null) {
            return component as T
        }

        val factory = factories[clazz] as? ComponentFactory<T>
            ?: throw IllegalArgumentException("There is no factory for component class $clazz")

        val newComponent = factory.create()
        components[clazz] = newComponent
        return newComponent
    }
}