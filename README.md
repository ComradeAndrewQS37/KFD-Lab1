# KFD-Lab1
В рамках лабораторной работы было необходимо реализовать алгоритм и структуру данных 
## Задание 1
**Задача:** _№4_ Сортировка вставками\
**Описание:** Написаны функции для сортировки в естественном порядке, в обратном порядке а также с использованием Comparator для задания кастомного порядка элементов
## Задание 2
**Задача:** _№12_ Бинарное дерево поиска для целых чисел. Программа получает на вход последовательность целых чисел и строит из них дерево. Элементы в деревья добавляются в соответствии с результатом поиска их места. Если элемент уже существует в дереве, добавлять его не надо. Балансировка дерева не производится. \
На вход программа получает последовательность натуральных чисел. Последовательность завершается числом 0, которое означает конец ввода, и добавлять его в дерево не надо. Выведите все элементы полученного дерева в порядке возрастания. \
**Описание:** Бинарное дерево поиска написано как реализация интрефейса `Collection<T>` (остались нереализованными только функции `retainAll` и `remove` для итератора), поэтому все основные функции бинарного дерева написаны как переопределения функций этого интерфейса. Дополнительно к этому написана функция, реализующая обход дерева в порядке Левое-Корень-Правое и применяющая некоторую функцию к каждой вершине дерева.
## Интерфейс
Пользователь вводит последовательность целых чисел, которую программа
1. Переводит в список и сортирует ставками
2. Добавляет в бинарное дерево поиска и выводит все элементы получившегося дерева в порядке возрастания
