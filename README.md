# Лабораторная работа № 4. Сборка проекта с Maven и модульное тестирование с JUnit

**ФИО:** Панфилов Евгений Павлович
**Группа:** ФИТ-251
**JDK:** 25 LTS
**IDE:** OpenIDE

## Описание

Проект лабораторной работы № 3 переведён на Maven. Настроена сборка JAR, написаны модульные тесты на JUnit.

## Структура проекта

- src/main/java/ — исходный код (app, geometry2d, geometry3d, exceptions, storage)
- src/test/java/ — тесты (CircleTest, RectangleTest, CylinderTest)
- data/ — файлы input.txt и output.bin
- pom.xml — конфигурация Maven

## Команды

Запуск тестов:
mvn test

Сборка JAR:
mvn clean package

Запуск программы:
java -jar target/lab04-1.0-SNAPSHOT.jar

## Проверка обнаружения ошибки (Задание 5)

В файле Rectangle.java в методе area() изменил формулу с "return width * height" на "return width * height + 1".

Запустил mvn test. Тест testAreaAndPerimeter в RectangleTest упал с ошибкой AssertionFailedError: expected 12.0 but was 13.0. Сборка завершилась с BUILD FAILURE.

Вернул правильную формулу. Все тесты прошли успешно: Tests run: 8, Failures: 0, Errors: 0, Skipped: 0. BUILD SUCCESS.

## Результаты тестирования

- CircleTest: 2 теста пройдены
- RectangleTest: 2 теста пройдены
- CylinderTest: 4 теста пройдены
- Итого: 8 тестов, все пройдены

## Что сделано

1. Проект переведён на Maven в ветке lab-4-maven
2. Создан pom.xml с Java 25 и UTF-8
3. Подключён JUnit Jupiter 5.10.2
4. Настроены плагины compiler, surefire, jar
5. Написаны тесты для Circle, Rectangle, Cylinder (позитивные и негативные сценарии)
6. Проверено обнаружение ошибок через тесты
7. Собран и запущен исполняемый JAR

