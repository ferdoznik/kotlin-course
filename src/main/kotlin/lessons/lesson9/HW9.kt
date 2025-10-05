package lessons.lesson9

class HW9 {
    fun main(args: Array<String>) {

        //Работа с массивами (Array)

        // 1) Массив из 5 Int (1..5)
        val a1: IntArray = IntArray(5) { it + 1 }
        println("1: " + a1.joinToString())

        // 2) Пустой массив строк размером 10
        val a2: Array<String> = Array(10) { "" }
        println("2: size=${a2.size}, sample='${a2[0]}'")

        // 3) Массив из 5 Double = удвоенный индекс
        val a3: DoubleArray = DoubleArray(5) { it * 2.0 }
        println("3: " + a3.joinToString())

        // 4) Массив из 5 Int, присвоить i*3 циклом
        val a4: Array<Int> = Array(5) { 0 }
        for (i in a4.indices) {
            a4[i] = i * 3
        }
        println("4: " + a4.joinToString())

        // 5) Массив из 3 nullable строк (одна null, две строки)
        val a5: Array<String?> = arrayOf<String?>(null, "Hello", "Kotlin")
        println("5: " + a5.joinToString())

        // 6) Копирование массива в новый массив в цикле
        val src: IntArray = intArrayOf(10, 20, 30, 40)
        val dst: IntArray = IntArray(src.size)
        for (i in src.indices) dst[i] = src[i]
        println("6: src=" + src.joinToString() + " -> dst=" + dst.joinToString())

        // 7) Разность двух массивов покомпонентно, печать результата
        val left: IntArray = intArrayOf(9, 8, 7, 6)
        val right: IntArray = intArrayOf(1, 2, 3, 4)
        val diff: IntArray = IntArray(left.size)
        for (i in left.indices) diff[i] = left[i] - right[i]
        println("7: " + diff.joinToString())

        // 8) Найти индекс элемента со значением 5 (while). Если нет — -1
        val a8: IntArray = intArrayOf(2, 4, 5, 7, 9)
        var idx = 0
        var foundIndex = -1
        while (idx < a8.size) {
            if (a8[idx] == 5) { foundIndex = idx; break }
            idx++
        }
        println("8: index of 5 -> $foundIndex")

        // 9) Вывести каждый элемент + “чётное/нечётное”
        val a9: IntArray = intArrayOf(1, 2, 3, 4, 5, 6)
        for (value in a9) {
            val tag = if (value % 2 == 0) "чётное" else "нечётное"
            println("9: $value — $tag")
        }

        // 10) Функция поиска подстроки в массиве строк
        val arr10: Array<String> = arrayOf("kotlin", "is", "awesome", "lang")
        val needle = "some"
        var found: String? = null
        for (item in arr10) {
            if (item.contains(needle)) {
                found = item
                break
            }
        }
        println(if (found != null) "10: найден элемент: $found" else "10: не найдено")

        //Работа со списками (List)

        // 1) Пустой неизменяемый список Int
        val l1: List<Int> = emptyList()
        println("L1: size=${l1.size}")

        // 2) Неизменяемый список строк из трёх элементов
        val l2: List<String> = listOf("Hello", "World", "Kotlin")
        println("L2: $l2")

        // 3) Изменяемый список Int 1..5
        val l3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
        println("L3: $l3")

        // 4) Добавить 6,7,8
        l3.add(6); l3.add(7); l3.add(8)
        println("L4: $l3")

        // 5) Удаление "World" из изменяемого списка строк
        val l5: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
        l5.remove("World")
        println("L5: $l5")

        // 6) Цикл по списку Int и печать
        val l6: List<Int> = listOf(3, 1, 4, 1, 5)
        for (v in l6) println("L6 item: $v")

        // 7) Получить второй элемент по индексу
        val l7: List<String> = listOf("red", "green", "blue")
        println("L7 second: " + l7[1])

        // 8) Заменить элемент с индексом 2
        val l8: MutableList<Int> = mutableListOf(10, 20, 30, 40)
        l8[2] = 999
        println("L8: $l8")

        // 9) Объединить два списка строк в новый через циклы
        val la: List<String> = listOf("a", "b", "c")
        val lb: List<String> = listOf("x", "y")
        val lc: MutableList<String> = mutableListOf()
        for (s in la) lc.add(s)
        for (s in lb) lc.add(s)
        println("L9 merged: $lc")

        // 10) Найти min и max в списке через цикл
        val l10: List<Int> = listOf(42, -7, 19, 0, 100, 5)
        var min = l10.first()
        var max = l10.first()
        for (i in 1..l10.lastIndex) {
            val v = l10[i]
            if (v < min) min = v
            if (v > max) max = v
        }
        println("L10 min=$min, max=$max")

        // 11) Новый список только из чётных чисел через цикл
        val l11Src: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val l11Even: MutableList<Int> = mutableListOf()
        for (v in l11Src) if (v % 2 == 0) l11Even.add(v)
        println("L11 even: $l11Even")

        //Работа с множествами (Set)

        // 1) Пустое неизменяемое множество Int
        val s1: Set<Int> = emptySet()
        println("S1: size=${s1.size}")

        // 2) Неизменяемое множество Int (1,2,3)
        val s2: Set<Int> = setOf(1, 2, 3)
        println("S2: $s2")

        // 3) Изменяемое множество строк
        val s3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
        println("S3: $s3")

        // 4) Добавить "Swift", "Go"
        s3.add("Swift")
        s3.add("Go")
        println("S4: $s3")

        // 5) Изменяемое множество Int удалить 2
        val s5: MutableSet<Int> = mutableSetOf(1, 2, 3, 2, 4)
        s5.remove(2)
        println("S5: $s5")

        // 6) Цикл по множеству Int и печать
        val s6: Set<Int> = setOf(9, 8, 7)
        for (v in s6) println("S6 item: $v")

        // 7) Функция проверки наличия строки в set через цикл
        val s7: Set<String> = setOf("alpha", "beta", "gamma")

        // проверка для "beta"
        var target = "beta"
        var exists = false
        for (item in s7) {
            if (item == target) { exists = true; break }
        }
        println("S7 contains '$target'? $exists")

        // проверка для "delta"
        target = "delta"
        exists = false
        for (item in s7) {
            if (item == target) { exists = true; break }
        }
        println("S7 contains '$target'? $exists")

        // 8) Множество строк -> изменяемый список строк циклом
        val s8: Set<String> = setOf("red", "green", "blue")
        val listFromSet: MutableList<String> = mutableListOf()
        for (item in s8) listFromSet.add(item)
        println("S8 -> list: $listFromSet")
    }
}