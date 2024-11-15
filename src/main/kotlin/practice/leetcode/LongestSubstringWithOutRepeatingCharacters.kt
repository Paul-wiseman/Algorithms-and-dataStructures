package practice.leetcode

fun main() {
    println(
        longestSubstringWithoutRepeatingCharacters("abcabcbb")
    )
}

fun longestSubstringWithoutRepeatingCharacters(s: String): Int {
    var totalLength = 0
    val stringSet = mutableSetOf<Char>()

    // sample input -> abcabcbb
    var l = 0
    var r = 0
    while (l <= r && r < s.length ) {
        if (!stringSet.contains(s[r])) {
            stringSet.add(s[r])
            totalLength = maxOf(totalLength, stringSet.size)
            r++
        } else {
            stringSet.remove(s[l])
            l++
        }
    }

    return totalLength
}
