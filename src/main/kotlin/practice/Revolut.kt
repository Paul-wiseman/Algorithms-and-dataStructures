package practice

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun interpolateMissingValues(times: DoubleArray, prices: DoubleArray): DoubleArray? {
    val interpolatedPrices = DoubleArray(prices.size)
    for (i in prices.indices) {
        if (java.lang.Double.isNaN(prices[i])) {
            var j = i - 1
            while (j >= 0 && java.lang.Double.isNaN(prices[j])) {
                j--
            }
            var k = i + 1
            while (k < prices.size && java.lang.Double.isNaN(prices[k])) {
                k++
            }
            if (j >= 0 && k < prices.size) {
                val x1 = times[j]
                val x2 = times[k]
                val y1 = prices[j]
                val y2 = prices[k]
                val x = times[i]
                val y = y1 + (x - x1) * (y2 - y1) / (x2 - x1)
                interpolatedPrices[i] = y
            }
        } else {
            interpolatedPrices[i] = prices[i]
        }
    }
    return interpolatedPrices
}

fun calcMissing(readings: List<String>) {
    val n = readings.size
    val times = DoubleArray(n)
    val prices = DoubleArray(n)
    var sum = 0.0
    var count = 0
    for (i in 0 until n) {
        val parts = readings[i].split("\t").toTypedArray()
        times[i] = i.toDouble()
        if (parts[1].startsWith("Missing")) {
            prices[i] = Double.NaN
        } else {
            prices[i] = parts[1].toDouble()
            sum += prices[i]
            count++
        }
    }
    val average = sum / count
    val interpolatedPrices = interpolateMissingValues(times, prices)
    for (i in 0 until n) {
        if (java.lang.Double.isNaN(prices[i])) {
            if (!java.lang.Double.isNaN(interpolatedPrices!![i])) {
                println(BigDecimal(interpolatedPrices[i]))
            } else {
                println(average.toBigDecimal(MathContext(2, RoundingMode.UP)))
            }
        }
    }
}


fun areAnagrams(K: String, O: String): Array<Int> {
    // If lengths are different, they cannot be anagrams
    if (K.length != O.length) {
        return arrayOf(0) // Not anagrams
    }

    // Create frequency arrays for both strings
    val frequencyK = IntArray(26) // Assuming only lowercase English letters
    val frequencyO = IntArray(26)

    // Fill the frequency arrays
    for (char in K) {
        frequencyK[char - 'a']++
    }
    for (char in O) {
        frequencyO[char - 'a']++
    }

    // Compare the frequency arrays
    return if (frequencyK.contentEquals(frequencyO)) {
        arrayOf(1) // Anagrams
    } else {
        arrayOf(0) // Not anagrams
    }
}

fun main() {
    // Test the function
    val K = "abacab"
    val O = "ab"
    val testArray = arrayOf(
//            arrayOf(112, 42, 83, 119),
//            arrayOf(56,125,56,49),
//            arrayOf(15, 78,101,43),
//            arrayOf(62,98,114,108),
        arrayOf(1, 2),
        arrayOf(3, 4)
    )

    println(flippingArray(testArray))


}

inline fun <reified T> showPayment(payment: Boolean): T {
    return when (T::class) {
        Boolean::class -> payment as T
        String::class -> "Sorry I can't make the payment now" as T
        Long::class -> 0L as T
        Int::class -> 2 as T
        else -> "Please specify a valid type" as T
    }
}

inline fun <reified T> testFunction(input: T) {
    println(input)
    println("Type of T is ${T::class.java}")
}

fun bubbleSort(array: Array<Int>): Array<Int> {

    for (i in array.indices.reversed()) {
        for (j in 0 until array.size - 1) {
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1)
            }
        }
    }
    return array
}

fun flippingArray(array: Array<Array<Int>>): Int {
    val arrayList = mutableListOf<Int>()

    for (i in 0..array.lastIndex / 2) {
        for (j in 0..array[i].lastIndex / 2) {
            val a0 = array[i][j]
            val a1 = array[i][array[i].lastIndex - j]
            val b0 = array[array.lastIndex - i][j]
            val b1 = array[array.lastIndex - i][array.lastIndex - j]

            val maxElementRow = Math.max(a0, a1)
            val maxElementLastRow = Math.max(b0, b1)
            arrayList.add(Math.max(maxElementRow, maxElementLastRow))
        }
    }

    return arrayList.sum()
}

fun selectionSort(array: Array<Int>): Array<Int> {
    for (i in array.indices) {
        val current = array[i]
        for (j in 0..i) {

        }
    }

    return array
}

fun swap(array: Array<Int>, a: Int, b: Int) {

    if (array[a] == array[b]) {
        return
    }

    val arrayB = array[b]
    array[b] = array[a]
    array[a] = arrayB
}

fun daysFromToday(dateString: String): Long {
    // Define the date format
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    // Parse the date string into an OffsetDateTime object
    val date = OffsetDateTime.parse(dateString, formatter)

    // Get the current date (today)
    val today = OffsetDateTime.now()

    // Calculate the difference in days
    return ChronoUnit.DAYS.between(date.toLocalDate(), today.toLocalDate())
}

