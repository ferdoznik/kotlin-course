package lessons.lesson8.homeworks

object HW8 {

    @JvmStatic
    fun main(args: Array<String>) {
        phrase(arg = "Это невозможно выполнить за один день")
        phrase(arg = "Я не уверен в успехе этого проекта")
        phrase(arg = "Произошла катастрофа на сервере")
        phrase(arg = "Этот код работает без проблем")
        phrase(arg = "Удача")

        task2(log = "Пользователь вошел в систему -> 2021-12-01 09:48:23")
        task3(arg = "4539 1488 0343 6467")
        task4(arg = "username@example.com")
        task5(arg = "C:/Пользователи/Документы/report.txt")
        task5(arg = "D:/good.themes/dracula.theme")
        task6(arg = "Котлин лучший язык программирования")
    }

    // 1) Преобразование строк
    fun phrase(arg: String) {
        val phrase = when {
            arg.contains(other = "невозможно") ->
                arg.replace(
                    oldValue = "невозможно",
                    newValue = "совершенно точно возможно, просто требует времени"
                )

            arg.startsWith(prefix = "Я не уверен") ->
                arg.plus(other = ", но моя интуиция говорит об обратном")

            arg.contains(other = "катастрофа") ->
                arg.replace(
                    oldValue = "катастрофа",
                    newValue = "интересное событие"
                )

            arg.endsWith(suffix = "без проблем") ->
                arg.replace(
                    oldValue = "без проблем",
                    newValue = "с парой интересных вызовов на пути"
                )

            // одно слово (нет пробелов/табов/переводов строки)
            !arg.contains(Regex("\\s")) ->
                "Иногда, $arg, но не всегда"

            else -> arg
        }
        println(phrase)
    }

    // 2) Извлечение даты и времени через indexOf/substring (без split)
    fun task2(log: String) {
        val arrow = log.indexOf("->")
        if (arrow == -1) return
        val right = log.substring(arrow + 2).trim()      // "YYYY-MM-DD HH:MM:SS"
        val space = right.indexOf(' ')
        if (space == -1) return
        val date = right.substring(0, space)
        val time = right.substring(space + 1)
        println(date)
        println(time)
    }

    // 3) Маскирование номера карты
    fun task3(arg: String) = println(maskCard(arg))
    private fun maskCard(number: String): String {
        val total = number.count { it.isDigit() }
        val toMask = (total - 4).coerceAtLeast(0)
        var seen = 0
        return buildString {
            for (ch in number) {
                if (ch.isDigit()) {
                    append(if (seen < toMask) '*' else ch)
                    seen++
                } else append(ch)
            }
        }
    }

    // 4) Форматирование e-mail
    fun task4(arg: String) = println(formatEmailV2(arg))
    private fun formatEmailV2(email: String): String =
        email.replace("@", " [at] ").replace(".", " [dot] ")

    // 5) Имя файла из пути
    fun task5(arg: String) = println(fileNameV2(arg))
    private fun fileNameV2(path: String): String =
        path.replace('\\', '/').substringAfterLast('/')

    // 6) Аббревиатура из фразы
    fun task6(arg: String) {
        val words = arg.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }
        var counter = ""
        for (word in words) {
            counter += word[0].uppercase()
        }
        println(counter)
    }
}