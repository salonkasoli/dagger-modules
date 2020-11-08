## Как использовать Dagger2 в многомодульной архитектуре и не выстрелить себе в колено

В проекте присутствуют 5 модулей:
*  app
*  di_core
*  text_module
*  some_other_module
*  some_other_module_api

Демонстрируется способ передачи зависимостей из модуля **some_other_module** в модуль **text_module**
таким образом, что последний знает только о внешнем контракте **some_other_module_api**.
Система корректно восстанавливается после убийства Application и создает все зависимости лениво
(по мере необходимости).

Далее следует краткое описание модулей приложения.

## di_core

Модуль, который подключается во все модули, желающие принимать участие в инъекции зависимостей.
Содержит в себе необходимые классы для правильного создания / пересоздания dagger - компонентов.

## some_other_module

Модуль, содержащий в себе реализацию, необходимую для передачи. Его в себя подключает только **app**,
чтобы собрать все приложение целиком.

## some_other_module_api

Модуль, содержащий в себе интерфейсы. Его подключают в себя те, кто хочет получить какие-то зависимости
из **some_other_module**, не заботясь о деталях реализации.

## text_module

Конечный модуль, "фича". Подключает в себя **some_other_module_api**, чтобы использовать зависимости
из **some_other_module**.

## app

Модуль, инициализирующий DI и собирающий отдельные части приложения воедино.
В пакете deps лежат классы, необходимые для создания и прокидывания зависимостей.
Ключевым является понимание того, что все components в Injector создаются в момент их необходимости.
В данном примере TextComponent требует для своего создания TextDepsComponent, который,
в свою очередь, нуждается в OtherComponent:

```kotlin
/// Фабрика TextComponent
class TextComponentFactory : ComponentFactory<TextComponent> {

    override fun create(): TextComponent {
        return DaggerTextComponent.builder()
            // Требуется TextDepsComponent
            .textDeps(Injector.get(TextDepsComponent::class.java).getDeps())
            .build()
    }
}
```

```kotlin
// фабрика TextDepsComponent
class Factory : ComponentFactory<TextDepsComponent> {

        override fun create(): TextDepsComponent {
            return DaggerTextDepsComponent.builder()
                // Требуется OtherComponent
                .otherRepository(Injector.get(OtherComponent::class.java).repo())
                .build()
        }
    }
```

Пока вы находитесьна MainActivity не создан ни один из этих компонентов.
Однако, когда вы вызываете внутри TextActivity
```kotlin
    Injector.get(TextComponent::class.java)
```
Injector сначала пытается создать TextComponent. В процессе создания мы запрашиваем
TextDepsComponent, что в свою очередь приведет к созданию OtherComponent и, возвращаясь по цепочке
вызовов будет, наконец, создан TextComponent.

Как можно заметить, совершенно необязательно создавать DepsComponent
(что продемонстрированно в OtherComponentFactory). DepsComponent были придуманы как инструмент
для dagger-генерации зависимостей.