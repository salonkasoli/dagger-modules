package com.example.di

/**
 * Интерфейс-маркер для всех dagger-компонентов в наши модулях.
 */
interface Component

/**
 * Интерфейс для компонентов - провайдеров зависимостей.
 */
interface DepsComponent : Component

/**
 * Интерфейс для компонентов фичей.
 */
interface FeatureComponent : Component