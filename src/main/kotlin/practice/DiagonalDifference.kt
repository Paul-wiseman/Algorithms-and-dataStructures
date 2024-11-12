package practice

fun main() {
    val test = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(9, 8, 9)
    )
    println(diagonalDifference(test))
}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var firstList = mutableListOf<Int>()
    var secondList = mutableListOf<Int>()
    for (i in arr.indices) {
        firstList.add(arr[i][i])
        secondList.add(arr[i][arr[i].lastIndex - i])
    }

    return Math.abs(firstList.sum() - secondList.sum())
}