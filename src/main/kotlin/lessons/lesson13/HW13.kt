package lessons.lesson13

class HW13 {
    // ---------- ИСХОДНАЯ КОЛЛЕКЦИЯ ----------
    val classicCars = listOf(
        "Ford Mustang",
        "Chevrolet Camaro",
        "Dodge Charger",
        "Pontiac GTO",
        "Cadillac Eldorado"
    )

// ---------- ЗАДАЧИ НА ПРИВЕДЕНИЕ КОЛЛЕКЦИИ К ЗНАЧЕНИЮ ----------

    /** 1. Проверить, что размер коллекции больше 5 элементов */
    fun task1(): Boolean = classicCars.size > 5

    /** 2. Проверить, что коллекция пустая */
    fun task2(): Boolean = classicCars.isEmpty()

    /** 3. Проверить, что коллекция не пустая */
    fun task3(): Boolean = classicCars.isNotEmpty()

    /** 4. Взять элемент по индексу или создать значение, если индекса не существует */
    fun task4() = classicCars.getOrElse(2) { 10 }

    /** 5. Собрать коллекцию в строку */
    fun task5() = classicCars.joinToString()

    /** 6. Посчитать сумму всех значений (используем годы выпуска этих моделей) */
    val carYears = listOf(1965, 1967, 1969, 1970, 1959)
    fun task6(): Int = carYears.sum()

    /** 7. Посчитать среднее значение годов */
    fun task7(): Double = carYears.average()

    /** 8. Взять максимальный год */
    fun task8(): Int? = carYears.maxOrNull()

    /** 9. Взять минимальный год */
    fun task9(): Int? = carYears.minOrNull()

    /** 10. Взять первый автомобиль или null */
    fun task10(): String? = classicCars.firstOrNull()

    /** 11. Проверить, что коллекция содержит элемент */
    fun task11(model: String): Boolean = model in classicCars

    // ---------- ПРОВЕРКА РЕЗУЛЬТАТОВ ----------
    fun main() {
        println("1) Коллекция > 5 элементов: ${task1()}")
        println("2) Коллекция пустая: ${task2()}")
        println("3) Коллекция не пустая: ${task3()}")
        println("4) Элемент с индексом 10 или значение по умолчанию: ${task4()}")
        println("5) Коллекция в строку: ${task5()}")
        println("6) Сумма годов выпуска: ${task6()}")
        println("7) Средний год выпуска: ${task7()}")
        println("8) Максимальный год: ${task8()}")
        println("9) Минимальный год: ${task9()}")
        println("10) Первый автомобиль: ${task10()}")
        println("11) Содержит ли 'Dodge Charger': ${task11("Dodge Charger")}")
    }

    /* =========================
   Задачи 12–23: обработка коллекций
   ========================= */
    val baseInts: List<Int> = listOf(-1, 2, -3, 4, -5, 8, 264, 18, 19, 25, 30, 31)
    val baseNullableText: List<String?> = listOf("кот", null, "собака", "рыба", null, "дом")
    val baseWords: List<String> = listOf("кот", "кит", "сон", "сад", "банан", "абрикос", "вишня")
    val grades: List<Int> = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    val catalogItems: List<String> = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы",
        "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга",
        "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор",
        "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра",
        "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед",
        "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик",
        "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    val numbers: List<Int> = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    val ages: List<Int?> = listOf(22, 18, 30, 45, 17, null, 60)

    /** 12. Отфильтровать коллекцию по диапазону 18–30 */
    fun task12() = baseInts.filter { it in 18..30 }

    /** 13. Выбрать числа, которые НЕ делятся на 2 и 3 одновременно */
    fun task13() = baseInts.filterNot { it % 6 == 0 }                              // filterNot

    /** 14. Очистить текстовую коллекцию от null элементов */
    fun task14() = baseNullableText.filterNotNull()      // filterNotNull

    /** 15. Преобразовать текстовую коллекцию в коллекцию длин слов */
    fun task15() = baseWords.map { it.length }       // map

    /** 16. Преобразовать текстовую коллекцию в мапу: ключ — перевёрнутое слово, значение — длина */
    fun task16() = baseWords.associate { it.reversed() to it.length }                   // associate

    /** 17. Отсортировать список в алфавитном порядке */
    fun task17() = baseWords.sorted()               // sorted

    /** 18. Взять первые 3 элемента списка */
    fun task18() = baseInts.take(3) // take

    /** 19. Распечатать квадраты элементов списка */
    fun task19() = baseInts.forEach { println(it * it) }

    /** 20. Группировать список по первой букве слов */
    fun task20() = baseWords.groupBy { it.firstOrNull() ?: '\u0000' } // groupBy

    /** 21. Очистить список от дублей */
    fun task21() = numbers.distinct() // distinct

    /** 22. Отсортировать список по убыванию */
    fun task22() = numbers.sortedDescending() // sortedDescending

    /** 23. Взять последние 3 элемента списка */
    fun task23() = baseInts.takeLast(3)                         // takeLast

    /* =========================
       Задача 24: Характеристика числовой коллекции (when)
       ========================= */
    /**
     * 24. Вернуть характеристику:
     * Пусто / Короткая / Стартовая / Массивная / Сбалансированная / Клейкая /
     * Отрицательная / Положительная / Пи***тая / Уникальная
     */
    fun task24(nums: List<Int>): String = when {
        nums.isEmpty() -> "Пусто"
        nums.size < 5 -> "Короткая"
        nums.firstOrNull() == 0 -> "Стартовая"
        nums.sum() > 10_000 -> "Массивная"
        nums.isNotEmpty() && nums.average() == 10.0 -> "Сбалансированная"
        nums.joinToString("").length == 20 -> "Клейкая"
        (nums.maxOrNull() ?: Int.MIN_VALUE) < -10 -> "Отрицательная"
        (nums.minOrNull() ?: Int.MAX_VALUE) > 1000 -> "Положительная"
        nums.containsAll(listOf(3, 14)) -> "Пи***тая"
        else -> "Уникальная"
    }

    /* =========================
       Задача 25: Анализ учебных оценок
       ========================= */
    /** 25. Оставить оценки >= 60, отсортировать по возрастанию и взять первые 3 */
    fun task25() = grades.filter { it >= 60 }.sorted().take(3)

    /* =========================
       Задача 26: Создание каталога по первой букве
       ========================= */
    /** 26. Привести к нижнему регистру и сгруппировать по первой букве (groupBy) */
    fun task26() = catalogItems.map { it.lowercase() }.groupBy { it.first() }

    /* =========================
       Задание 27: Подсчёт средней длины слов
       ========================= */
    /** 27. Перевести слова в длины, посчитать среднее и вернуть строку формата с 2 знаками */
    fun task27(): String {
        val avg = catalogItems.map { it.lowercase().length }.average()
        return String.format("%.2f", avg)
    }

    /* =========================
       Задание 28: Категоризация чисел
       ========================= */
    /** 28. Уникальные числа, сортировка ↓ и группировка по чётности */
    fun task28() = numbers.distinct()
        .sortedDescending()
        .groupBy { if (it % 2 == 0) "четные" else "нечетные" }

    /* =========================
       Задание 29: Поиск первого подходящего возраста
       ========================= */
    /** 29. Найти первый возраст > порога, иначе null (nullable входы учитываются) */
    fun task29(threshold: Int = 18) = ages.filterNotNull().firstOrNull { it > threshold }
}