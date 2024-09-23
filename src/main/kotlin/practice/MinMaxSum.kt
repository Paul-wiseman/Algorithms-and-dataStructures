package practice

fun main(){
    val test = arrayOf(256741038, 623958417, 467905213, 714532089, 938071625)

    miniMaxSum(test)
}

fun miniMaxSum(arr: Array<Int>) {
    // Write your code here
    val arrLong = arr.map { it.toLong() }

    // Calculate the total sum
    val totalSum = arrLong.sum()

    // Calculate the minimum and maximum sums
    val minElement = arrLong.minOrNull() ?: 0L
    val maxElement = arrLong.maxOrNull() ?: 0L

    // Calculate lowest and largest sum
    val lowestSum = totalSum - maxElement
    val largestSum = totalSum - minElement

    // Output the result
    println("$lowestSum $largestSum")
}