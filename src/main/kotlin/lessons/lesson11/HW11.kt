package lessons.lesson11

class HW11 {
    /* ===================== ЗАДАЧИ НА СИГНАТУРУ МЕТОДА ===================== */

    // 1) Не принимает аргументов и не возвращает значения.
    public fun task1(): Unit {}

    // 2) Принимает два целых числа и возвращает их сумму.
    public fun task2(a: Int, b: Int): Int = a + b

    // 3) Принимает строку и ничего не возвращает.
    public fun task3(text: String): Unit {}

    // 4) Принимает список Int и возвращает среднее Double.
    public fun task4(nums: List<Int>): Double = if (nums.isEmpty()) 0.0 else nums.average()

    // 5) Принимает nullable String и возвращает её длину как nullable Int; доступна только в файле.
    private fun task5(s: String?): Int? = s?.length

    // 6) Не принимает аргументов и возвращает nullable Double.
    public fun task6(): Double? = null

    // 7) Принимает nullable список Int, ничего не возвращает; доступна только в файле.
    private fun task7(nums: List<Int>?): Unit {}

    // 8) Принимает Int и возвращает nullable String.
    public fun task8(n: Int): String? = n.toString()

    // 9) Не принимает аргументов и возвращает список nullable строк.
    public fun task9(): List<String?> = listOf("a", null, "b")

    // 10) Принимает nullable String и nullable Int и возвращает nullable Boolean.
    public fun task10(s: String?, n: Int?): Boolean? =
        if (s == null || n == null) null else (s.length == n)


    /* ===================== ЗАДАЧИ НА НАПИСАНИЕ КОДА ===================== */

    // 1) multiplyByTwo: принимает Int и возвращает его, умноженное на 2.
    public fun multiplyByTwo(x: Int): Int = x * 2

    // 2) isEven: true, если число чётное; иначе false.
    public fun isEven(x: Int): Boolean = x % 2 == 0

    // 3) printNumbersUntil: печатает 1..n; если n < 1 — завершает работу (return).
    public fun printNumbersUntil(n: Int) {
        if (n < 1) return
        for (i in 1..n) println(i)
    }

    // 4) findFirstNegative: возвращает первое отрицательное число или null.
    public fun findFirstNegative(nums: List<Int>): Int? {
        for (v in nums) if (v < 0) return v
        return null
        // альтернативно: nums.firstOrNull { it < 0 }
    }

    // 5) processList: печатает строки; при встрече null — немедленно return (ничего не возвращает).
    public fun processList(items: List<String?>) {
        for (s in items) {
            if (s == null) return
            println(s)
        }
    }

}