package lessons.lesson6.homeworks

class HW6 {
    // Задание 1
    fun printSeason(month: Int) {
        if (month !in 1..12) {
            println("Ошибка: месяц должен быть от 1 до 12")
            return
        }
        val season = when (month) {
            12, 1, 2 -> "Зима"
            in 3..5 -> "Весна"
            in 6..8 -> "Лето"
            in 9..11 -> "Осень"
            else -> "Неизвестно"
        }
        println("Месяц $month → $season")
    }
    // Задание 2
    fun printDogAgeInHumanYears(dogAge: Double) {
        if (dogAge <= 0) {
            println("Ошибка: возраст собаки должен быть положительным")
            return
        }
        val humanAge = if (dogAge <= 2) dogAge * 10.5 else 21 + (dogAge - 2) * 4
        println("Возраст собаки $dogAge → $humanAge человеческих лет")
    }
    // Задание 3
    fun printTransportMethod(distanceKm: Double) {
        if (distanceKm <= 0) {
            println("Ошибка: расстояние должно быть положительным")
            return
        }
        val method = when {
            distanceKm <= 1 -> "пешком"
            distanceKm <= 5 -> "велосипед"
            else -> "автотранспорт"
        }
        println("Маршрут $distanceKm км → $method")
    }
    // Задание 4
    fun printBonusPoints(amount: Double) {
        if (amount < 0) {
            println("Ошибка: сумма покупки не может быть отрицательной")
            return
        }
        val points = if (amount <= 1000) {
            (amount / 100).toInt() * 2
        } else {
            (amount / 100).toInt() * 3
        }
        println("Покупка на $amount руб → $points баллов")
    }
    // Задание 5
    fun printFileType(extension: String) {
        val fileType = when (extension.lowercase()) {
            "txt", "doc", "docx" -> "Текстовый документ"
            "jpg", "jpeg", "png", "gif" -> "Изображение"
            "xls", "xlsx", "csv" -> "Таблица"
            else -> "Неизвестный тип"
        }
        println("Файл .$extension → $fileType")
    }
    // Задание 6
    fun convertTemperature(value: Double, unit: String) {
        when (unit.uppercase()) {
            "C" -> {
                val result = value * 9 / 5 + 32
                print("$value C → $result "); println("F")
            }
            "F" -> {
                val result = (value - 32) * 5 / 9
                print("$value F → $result "); println("C")
            }
            else -> println("Ошибка: единица измерения должна быть 'C' или 'F'")
        }
    }
    // Задание 7
    fun recommendClothes(temp: Double) {
        val recommendation = when {
            temp < -30 || temp > 35 -> "Рекомендуем не выходить из дома"
            temp < 10 -> "куртка и шапка"
            temp in 10.0..18.0 -> "ветровка"
            else -> "футболка и шорты"
        }
        println("Температура $temp° → $recommendation")
    }
    // Задание 8
    fun getMovieCategory(age: Int): String {
        if (age < 0) return "Ошибка: возраст не может быть отрицательным"
        return when (age) {
            in 0..9 -> "детские"
            in 10..18 -> "подростковые"
            else -> "18+"
        }
    }
}