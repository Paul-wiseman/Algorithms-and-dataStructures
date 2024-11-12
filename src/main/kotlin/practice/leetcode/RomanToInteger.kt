package practice.leetcode

fun main() {
    println(romanToInteger("MCMXCIV"))
}

private fun romanToInteger(s: String): Int {
    val mappings = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    var result = 0
    val length = s.length
    var n = 0
    while (n < length) {
        if ((n < length - 1) && (mappings[s[n]]!! < mappings[s[n + 1]]!!)) {
            result += (mappings[s[n + 1]]!! - mappings[s[n]]!!)
            n += 2
        } else {
            result += mappings[s[n]]!!
            n++
        }
    }
    return result
}