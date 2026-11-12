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




