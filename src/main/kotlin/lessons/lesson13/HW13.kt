package lessons.lesson13

object HW13 {
    fun main() {
    /** 1. Среднее время выполнения тестов */
    fun task1(): Double {
        // Дан словарь: имя теста -> время выполнения (сек)
        val testDurations: Map<String, Double> = mapOf(
            "testLogin" to 2.4, "testSignup" to 3.1, "testCheckout" to 4.7
        )
        // Решение: среднее по значениям
        return testDurations.values.average() // average
    }

    /** 2. Список всех тестовых методов (ключи словаря) */
    fun task2(): List<String> {
        // Дан словарь: имя метода -> метаданные
        val meta: Map<String, String> = mapOf(
            "testLogin" to "priority=high", "testSignup" to "owner=qa", "testSearch" to "smoke=true"
        )
        // Решение: получить список ключей
        return meta.keys.toList() // keys
    }

    /** 3. Добавить новый тест и результат в изменяемый словарь */
    fun task3(): MutableMap<String, String> {
        // Дан изменяемый словарь: тест -> результат
        val results = mutableMapOf("t1" to "passed", "t2" to "failed")
        // Решение: добавить запись
        results["t3"] = "passed" // put через индексатор
        return results
    }

    /** 4. Посчитать количество успешных тестов (passed) */
    fun task4(): Int {
        // Дан словарь: тест -> {passed|failed|skipped}
        val results = mapOf("a" to "passed", "b" to "failed", "c" to "passed", "d" to "skipped")
        // Решение: посчитать по условию
        return results.count { it.value == "passed" } // count
    }

    /** 5. Удалить запись о баге по ключу */
    fun task5(): MutableMap<String, String> {
        // Дан изменяемый словарь: баг -> статус {open|fixed|in_progress}
        val bugs = mutableMapOf("MB-100" to "open", "MB-101" to "fixed", "MB-102" to "in_progress")
        // Решение: удалить запись со статусом fixed
        val toRemove = bugs.entries.firstOrNull { it.value == "fixed" }?.key
        if (toRemove != null) bugs.remove(toRemove) // remove
        return bugs
    }

    /** 6. Сообщение о проверке страниц: "URL -> статус" */
    fun task6() {
        // Дан словарь: URL -> статус ответа
        val pages = mapOf(
            "https://site/a" to 200, "https://site/b" to 404, "https://site/c" to 500
        )
        // Решение: вывести сообщения
        pages.forEach { (url, status) -> println("Page $url checked with status $status") } // forEach + деструктуризация
    }

    /** 7. Найти сервисы с ответом дольше порога */
    fun task7(thresholdMs: Long = 300): Map<String, Long> {
        // Дан словарь: сервис -> время ответа (мс)
        val timings = mapOf("auth" to 120L, "billing" to 420L, "search" to 310L, "chat" to 200L)
        // Решение: фильтрация
        return timings.filter { it.value > thresholdMs } // filter по Map.Entry
    }

    /** 8. Статус для endpoint или дефолт "not tested" */
    fun task8(endpoint: String = "/v1/user"): String {
        // Дан словарь: endpoint -> статус
        val api = mapOf(
            "/v1/login" to "200 OK", "/v1/orders" to "500 ERR"
        )
        // Решение: получить или значение по умолчанию
        return api.getOrElse(endpoint) { "not tested" } // getOrElse
    }

    /** 9. Получить 'browserType' (не null) */
    fun task9(): String {
        // Дан словарь: параметр -> значение
        val cfg = mapOf(
            "env" to "staging", "browserType" to "chrome", "headless" to "true"
        )
        // Решение: получить гарантированно существующее значение
        return cfg.getValue("browserType") // getValue
    }

    /** 10. Копия словаря версий с добавленной версией */
    fun task10(): Map<String, String> {
        // Дан неизменяемый словарь: версия -> статус
        val versions = mapOf("1.0.0" to "stable", "1.1.0" to "stable")
        // Решение: через toMutableMap + put + toMap
        val copy = versions.toMutableMap() // toMutableMap
        copy["1.2.0"] = "beta"             // put
        return copy.toMap()                 // toMap
    }

    /** 11. Настройки для устройства или значения по умолчанию */
    fun task11(model: String = "Pixel 7"): String {
        // Дан словарь: модель -> настройки
        val mobile = mapOf("iPhone 14" to "ios=17;res=1179x2556", "Pixel 7" to "android=14;res=1080x2400")
        // Решение: получить или дефолт
        return mobile.getOrDefault(model, "defaults=mobile") // getOrDefault
    }

    /** 12. Содержит ли словарь код ошибки */
    fun task12(code: Int = 1002): Boolean {
        // Дан словарь: код ошибки -> описание
        val errors = mapOf(1001 to "Null ref", 1002 to "Timeout", 1003 to "Auth failed")
        // Решение: проверить наличие ключа
        return errors.containsKey(code) // containsKey
    }

    /** 13. Фильтр по версии в ключе "TestID_Version" */
    fun task13(version: String = "v2"): Map<String, String> {
        // Дан словарь: "Id_Version" -> статус
        val scenarios = mapOf(
            "Login_v1" to "Passed", "Payments_v2" to "Failed", "Search_v2" to "Skipped", "Profile_v3" to "Passed"
        )
        // Решение: по ключам
        return scenarios.filterKeys { it.contains(version) } // filterKeys
    }

    /** 14. Есть ли модули с Failed */
    fun task14(): Boolean {
        // Дан словарь: модуль -> результат
        val modules = mapOf("Auth" to "passed", "Billing" to "failed", "Search" to "passed")
        // Решение: проверка наличия не-прошедших
        return modules.any { it.value != "passed" } // any
    }

    /** 15. Добавить настройки из другого словаря (mutable) */
    fun task15(): MutableMap<String, String> {
        // Даны два словаря
        val env = mutableMapOf("threads" to "4", "region" to "eu-central")
        val extra = mapOf("browser" to "chrome", "retries" to "2")
        // Решение: добавить все
        env.putAll(extra) // putAll
        return env
    }

    /** 16. Объединить два неизменяемых словаря багов */
    fun task16(): Map<String, String> {
        // Даны словари
        val a = mapOf("MB-1" to "open", "MB-2" to "fixed")
        val b = mapOf("MB-3" to "open", "MB-4" to "in_review")
        // Решение: объединение
        return a + b // +
    }

    /** 17. Очистить изменяемый словарь временных данных */
    fun task17(): MutableMap<String, String> {
        // Дан изменяемый словарь
        val temp = mutableMapOf("runId" to "42", "startedAt" to "10:00", "note" to "warmup")
        // Решение: очистить
        temp.clear() // clear
        return temp
    }

    /** 18. Исключить "skipped" из отчёта */
    fun task18(): Map<String, String> {
        // Дан словарь
        val report = mapOf("t1" to "passed", "t2" to "skipped", "t3" to "failed", "t4" to "skipped")
        // Решение: убрать skipped
        return report.filterNot { it.value == "skipped" } // filterNot
    }

    /** 19. Копия конфигов без ряда ключей */
    fun task19(): Map<String, String> {
        // Дан словарь конфигов
        val cfg = mapOf("proxy" to "http://...", "debug" to "true", "retries" to "3", "locale" to "es-ES")
        // Решение: минус набор ключей
        return cfg - setOf("proxy", "debug") // -
    }

    /** 20. Список строк "Test ID: результат" */
    fun task20(): List<String> {
        // Дан словарь: testId -> result
        val results = mapOf("A-01" to "passed", "A-02" to "failed", "A-03" to "passed")
        // Решение: преобразовать пары в строки
        return results.map { (id, res) -> "Test $id: $res" } // map
    }

    /** 21. Mutable -> Immutable (архив) */
    fun task21(): Map<String, String> {
        // Дан изменяемый словарь
        val lastRun = mutableMapOf("L-1" to "passed", "L-2" to "failed")
        // Решение: в неизменяемый
        return lastRun.toMap() // toMap
    }

    /** 22. Заменить числовые ключи на строковые */
    fun task22(): Map<String, Double> {
        // Дан словарь
        val times = mapOf(1001 to 2.5, 1002 to 3.7, 1003 to 1.8)
        // Решение: преобразовать ключи
        return times.mapKeys { it.key.toString() } // mapKeys
    }

    /** 23. Увеличить оценки производительности на 10% */
    fun task23(): Map<String, Double> {
        // Дан словарь
        val perf = mapOf("1.0" to 200.0, "1.1" to 180.0, "2.0" to 220.0)
        // Решение: увеличить на 10%
        return perf.mapValues { it.value * 1.1 } // mapValues
    }

    /** 24. Пуст ли словарь ошибок компиляции тестов */
    fun task24(): Boolean {
        // Дан словарь
        val compileErrors = emptyMap<String, String>()
        // Решение: проверка пустоты
        return compileErrors.isEmpty() // isEmpty
    }

    /** 25. Ненулевой ли словарь результатов нагрузочного теста */
    fun task25(): Boolean {
        // Дан словарь
        val load = mapOf("baseline" to "ok", "spike" to "ok")
        // Решение: проверка непустоты
        return load.isNotEmpty() // isNotEmpty
    }

    /** 26. Все авто-тесты прошли успешно? */
    fun task26(): Boolean {
        // Дан словарь: test -> result
        val results = mapOf("X1" to "passed", "X2" to "passed", "X3" to "passed")
        // Решение: все passed?
        return results.all { it.value == "passed" } // all
    }

    /** 27. Есть ли хотя бы один упавший тест */
    fun task27(): Boolean {
        // Дан словарь: test -> result
        val results = mapOf("Y1" to "passed", "Y2" to "failed", "Y3" to "skipped")
        // Решение: наличие "failed"
        return results.containsValue("failed") // containsValue
    }

    /** 28. Не passed и содержит "optional" в названии */
    fun task28(): Map<String, String> {
        // Дан словарь: serviceName -> result
        val svc = mapOf(
            "user-optional" to "failed",
            "billing-core" to "passed",
            "report-optional" to "skipped",
            "inventory" to "passed"
        )
        // Решение: фильтрация по ключу и значению
        return svc.filter { (name, res) -> "optional" in name && res != "passed" } }
    }
}