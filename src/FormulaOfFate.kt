data class PsyType(
    val psyType: String = "",
    val sentence: String = "",
    var answer: Int = 0,
)

//private val sentences: Array<String> = arrayOf<String>(
//    "Я справляюсь с делами, где надо убеждать, инструктировать, распоряжаться.",
//    "Я легко решаю алгебраические задачи.",
//    "Я бы не смог работать санитаром в больнице, так как не переношу грязи.",
//    "В любую минуту я готов сразить соперника удачной репликой или достойно ответить на его выпад.",
//    "У меня мирные отношения с людьми, я избегаю споров и борьбы.",
//    "Когда я оказываюсь неподвижным, меня тянет в сон.",
//    "Я люблю мечтать, не задумываясь, насколько реальны мои мечты.",
//    "Я быстро подмечаю слабые стороны человека, идеи, и т.п."
//)
//
//private val letters = arrayOf<String>(
//    "Д", "Л", "Э", "Б", "П", "Н", "М", "С"
//)
//
//private val answerNums = Array<Int>(8) { 0 }
//


val psyTypes = arrayOf(
    PsyType("Д", "Я справляюсь с делами, где надо убеждать, инструктировать, распоряжаться."),
    PsyType("Л", "Я легко решаю алгебраические задачи."),
    PsyType("Э", "Я бы не смог работать санитаром в больнице, так как не переношу грязи."),
    PsyType("Б", "В любую минуту я готов сразить соперника удачной репликой или достойно ответить на его выпад."),
    PsyType("П", "У меня мирные отношения с людьми, я избегаю споров и борьбы."),
    PsyType("Н", "Когда я оказываюсь неподвижным, меня тянет в сон."),
    PsyType("М", "Я люблю мечтать, не задумываясь, насколько реальны мои мечты."),
    PsyType("С", "Я быстро подмечаю слабые стороны человека, идеи, и т.п."),
)

private val formulaOfDestiny = Array<PsyType>(8) { PsyType() }

/**
 * Вывести запрос на экран, получив строку запроса из поля sentence параметра psyType
 * Получить строку ответа.
 * Преобразовать строку в число, если ответ вернул Null - значением ответа будет 0
 * поместить ответ в поле answer параметра psyType
 */
//private fun request(psyType: PsyType):Int {
private fun request(psyType: PsyType) {
    println(psyType.sentence)

    //ждать и вернуть ввод с консоли
    val numAsString = readlnOrNull()

    //преобразовать строку в число
    val numOrNull: Int? = numAsString?.toIntOrNull();

    val num = numOrNull?:0

    psyType.answer = num

    //выйти из функции
    return

    //выйти из функции и вернуть число
//    return num
}


/**
 * Получить результат
 */
fun getFormulaOfDestiny(): String {
    requestCycle()
    sort()
    //преобразовать массив в строку ответа
    val formula = formulaOfDestiny.joinToString(prefix = "Формула Вашей Судьбы! : ", separator = "-") { it.psyType }
    return formula
}

/**
 * Сортировка значений
 */
private fun sort() {
    //перебираем позиции строки формулы судьбы
    for (count in 0..7) {
        //Получить индекс максимального значения.
        val indexOfMax = getIndexOfMax()

        //поместить его на соответствующее место формулы
        formulaOfDestiny[count] = psyTypes[indexOfMax]

        //обнулить найденный ответ с максимальным значением,
        //чтобы он не оказал влияния на поиск следующего значения.

//        answerNums[indexOfMax] = 0
        psyTypes[indexOfMax].answer = 0
    }
}

/**
 *  Получить индекс максимального значения.
 */
private fun getIndexOfMax(): Int {
    var indexOfMax = 0

    //перебираем строки ответов
    for (index in 0..7) {

//        if (answerNums[indexOfMax] < answerNums[index]) {
//            indexOfMax = index
//        }

        if (psyTypes[indexOfMax].answer < psyTypes[index].answer) {
            indexOfMax = index
        }
    }

    return indexOfMax
}


/**
 * Цикл запросов
 */
private fun requestCycle() {
    for (i in 0..7) {
//        answerNums[i] = request(sentences[i]) ?: 0
        request(psyTypes[i])
    }
}
