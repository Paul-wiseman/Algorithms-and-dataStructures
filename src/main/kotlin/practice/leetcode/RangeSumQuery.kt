package practice.leetcode

fun main() {
    val nums = intArrayOf(-2, 0, 3, -5, 2, -1)
    val left = 0
    val right = 2
    println(sumRange(nums, left, right))
}

private fun sumRange(nums: IntArray, left: Int, right: Int): Int {
    val sums = prefixSum(nums)
    return if (left > 0) {
        sums[right] - sums[left - 1]
    } else {
        sums[right]
    }
}

private fun prefixSum(nums: IntArray): IntArray {
    val sums = IntArray(nums.size)
    sums[0] = nums[0]
    for (i in 1..nums.lastIndex) {
        sums[i] = sums[i - 1] + nums[i]
    }
    return sums
}