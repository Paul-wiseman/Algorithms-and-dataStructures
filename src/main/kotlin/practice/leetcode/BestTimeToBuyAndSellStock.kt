package practice.leetcode

fun main() {
    println(
        bestTimeToBuyAndSellStock(intArrayOf(7,6,4,3,1))
    )
}

private fun bestTimeToBuyAndSellStock(prices: IntArray): Int {
    var bestProfit = 0
    var lowestPrice = prices[0]
    for (i in 1..prices.lastIndex) {
        val difference = prices[i] - lowestPrice
        if (difference > bestProfit) {
            bestProfit = difference
        }
        if (prices[i] < lowestPrice) {
            lowestPrice = prices[i]
        }
    }
    return bestProfit
}