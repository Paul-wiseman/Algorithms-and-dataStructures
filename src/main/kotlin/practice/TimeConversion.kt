package practice

fun main() {
    val testInput = "12:40:22AM"
    println(timeConversion(testInput))

}


fun timeConversion(s: String): String {
    val array = Array(100) {}
    val timeParts = s.split(":")
    var time = Time(
        hour = timeParts.first(),
        min = timeParts[1],
        sec = timeParts.last().dropLast(2),
        format = timeParts.last().takeLast(2)
    )

    return if (time.format == "AM") {
        if (time.hour == "12") {
            time = time.copy(hour = "00")
        }
        time.joinToStringWithOutFormat()
    } else {
        if (time.hour != "12") {
            val newHour = time.hour.toInt() + 12
            val newTime = time.copy(hour = newHour.toString())
            time = newTime
        }
        time.joinToStringWithOutFormat()
    }
}

data class Time(val hour: String, val min: String, val sec: String, val format: String) {
    fun joinToStringWithOutFormat(): String {
        return "$hour:$min:$sec"
    }

    override fun hashCode(): Int {
        super.hashCode()
        return arrayOf(hour, min).hashCode()
    }
}

fun convertToRomanNumerals(int: Int): String {
    val mappedValue = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M",
    )

    var romanNumeral = buildString {
        for ((key, value) in mappedValue) {
            while (int > key) {
                append(value)
            }
        }
    }
    return romanNumeral
}

fun convertIntegersToRomans(nums: List<Int>): List<String> {
    val table = listOf(
        1 to "I", 4 to "IV", 5 to "V", 9 to "IX", 10 to "X", 40 to "XL", 50 to "L",
        90 to "XC", 100 to "C", 400 to "CD", 500 to "D", 900 to "CM", 1000 to "M"
    )

    fun convert(num: Int): String {
        var n = num
        val roman = mutableListOf<String>()
        while (n > 0) {
            // Binary search for the largest value less than or equal to num
            val index = table.binarySearch {
                it.first.compareTo(n)
            }
            val correctedIndex = if (index >= 0) index else -index - 2  // Adjust if not found
            roman.add(table[correctedIndex].second)
            n -= table[correctedIndex].first
        }
        return roman.joinToString("")
    }

    return nums.map { convert(it) }
}

