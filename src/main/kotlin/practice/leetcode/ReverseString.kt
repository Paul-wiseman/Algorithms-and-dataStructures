package practice.leetcode

fun main() {
    val charArray = charArrayOf('h', 'e', 'l', 'l', 'o')
    reverseString(charArray)
    println(charArray.contentToString())
}


private fun reverseString(s: CharArray) {
    for (i in 0..(s.lastIndex / 2)) {
        swap(s, i, (s.lastIndex - i))
    }
}


fun swap(s: CharArray, i: Int, j: Int) {
    if (s[i] == s[j]) {
        return
    }
    var first = s[i]
    s[i] = s[j]
    s[j] = first
}