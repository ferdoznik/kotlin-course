package lessons.lesson10

class HW10 {
    fun main() {
        // 1) Пустой неизменяемый словарь (ключи и значения — Int)
        val emptyMap1: Map<Int, Int> = emptyMap()

        // 2) Неизменяемый словарь с ключами Float и значениями Double
        val floatsToDoubles = mapOf<Float, Double>(
            1.0f to 2.5,
            2.5f to 3.14,
            10.0f to 0.0
        )

        // 3) Изменяемый словарь Int -> String
        val mutableIntToString = mutableMapOf<Int, String>(
            1 to "one",
            2 to "two"
        )

        // 4) Добавление новых пар в изменяемый словарь
        val cars = mutableMapOf<String, String>("BMW" to "М5")
        cars ["Audi"] = "R8"
        // 5) Получение значения по ключу (существующему и отсутствующему)
        val result = cars["Mercedes"] // ключа нет → вернётся null
        if (result != null) {
            println(result)
        } else {
            println("No such key")
        }

        // 6) Удаление элемента по ключу
        cars.remove("BMW")

        // 7) Map<Double, Int> и вывод результата деления ключа на значение (+ обработка деления на 0)
        val divMap: Map<Double, Int> = mapOf(
            10.0 to 2,
            5.0 to 0,
            9.0 to 3
        )
        println("7) Деление ключа на значение:")
        for ((k, v) in divMap) {
            if (v == 0) {
                println("   $k / $v = бесконечность")
            } else {
                println("   $k / $v = ${k / v}")
            }
        }

        // 8) Изменение значения для существующего ключа
        mutableIntToString[1] = "ONE"

        // 9) Объединение двух словарей в третий изменяемый через циклы
        val mapA = mapOf(1 to "A", 5 to "B")
        val mapB = mapOf(5 to "B2", 7 to "C")
        val combined: MutableMap<Int, String> = mutableMapOf()
        for ((k, v) in mapA) combined[k] = v
        for ((k, v) in mapB) combined[k] = v // значения из B перезапишут значения из A при совпадении ключей
        println("9) combined = $combined")

        // 10) Map<String, List<Int>> и добавление нескольких элементов
        val scores: MutableMap<String, MutableList<Int>> = mutableMapOf(
            "Alice" to mutableListOf(10, 12),
            "Bob" to mutableListOf(7)
        )
        scores.getOrPut("Alice") { mutableListOf() }.add(15)
        scores.getOrPut("Carol") { mutableListOf() }.addAll(listOf(8, 11))
        println("10) scores = $scores")

        // 11) Map<Int, MutableSet<String>>: добавить данные, получить множество по ключу и добавить строку
        val setsMap: MutableMap<Int, MutableSet<String>> = mutableMapOf(
            1 to mutableSetOf("alpha", "beta"),
            2 to mutableSetOf("gamma")
        )
        val set1 = setsMap[1] ?: mutableSetOf<String>().also { setsMap[1] = it }
        set1.add("delta")
        println("11) setsMap[1] = ${setsMap[1]}")

        // 12) Словарь с ключами-парами чисел: найти значение, где в паре есть цифра 5 (в first или second)
        val pairKeyMap: Map<Pair<Int, Int>, String> = mapOf(
            (1 to 2) to "p12",
            (5 to 7) to "p57",
            (3 to 5) to "p35",
            (9 to 9) to "p99"
        )
        val withFive = pairKeyMap.filterKeys { (a, b) -> a == 5 || b == 5 }.values
        println("12) значения по парам, содержащим 5: $withFive")
//----------------------------------------------------------------------------------------------------------------------
        // 1) Словарь библиотека: автор -> список книг
        // mutable, потому что библиотека может пополняться
        val library: MutableMap<String, MutableList<String>> = mutableMapOf(
            "Толстой" to mutableListOf("Война и мир", "Анна Каренина"),
            "Достоевский" to mutableListOf("Преступление и наказание", "Идиот")
        )
        library["Булгаков"] = mutableListOf("Мастер и Маргарита")
        println("1) library = $library\n")

        // 2) Справочник растений: тип растения -> список названий
        // данные скорее справочные, поэтому достаточно неизменяемого Map
        val plants: Map<String, List<String>> = mapOf(
            "Цветы" to listOf("Роза", "Тюльпан", "Лилия"),
            "Деревья" to listOf("Дуб", "Берёза", "Сосна")
        )
        println("2) plants = $plants\n")

        // 3) Четвертьфиналы: команда -> список игроков
        // изменяемый словарь, чтобы можно было заменять игроков
        val quarterFinals: MutableMap<String, MutableList<String>> = mutableMapOf(
            "Tigers" to mutableListOf("Alex", "Bob", "Chris"),
            "Eagles" to mutableListOf("Dan", "Evan", "Finn")
        )
        quarterFinals["Tigers"]?.add("George") // заменили игрока
        println("3) quarterFinals = $quarterFinals\n")

        // 4) Курс лечения: дата -> список препаратов
        // дата удобна как ключ, значения — список лекарств
        val treatmentCourse = mapOf(
            "01 january" to listOf ("препарат 1"),
            "02 january" to listOf ("препарат 2")
        )

        // 5) Словарь путешественника: страна -> (город -> список интересных мест)
        // вложенные mutableMap, потому что можно добавлять страны, города и достопримечательности
        val travelGuide: MutableMap<String, MutableMap<String, MutableList<String>>> = mutableMapOf(
            "Испания" to mutableMapOf(
                "Барселона" to mutableListOf("Саграда Фамилия", "Парк Гуэль"),
                "Мадрид" to mutableListOf("Прада", "Пуэрта-дель-Соль")
            ),
            "Франция" to mutableMapOf(
                "Париж" to mutableListOf("Эйфелева башня", "Лувр")
            )
        )

        // добавим новую страну и город
        travelGuide["Италия"] = mutableMapOf(
            "Рим" to mutableListOf("Колизей", "Ватикан")
        )
    }
}