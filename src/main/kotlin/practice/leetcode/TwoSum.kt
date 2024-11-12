package practice.leetcode

fun main() {
    val arr = intArrayOf(2, 7, 11, 15)
    val target = 9
    println(twoSum(arr, target).contentToString())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (i in 0..nums.lastIndex) {
        val complement = target - nums[i]
        if (hashMap.containsKey(complement)) {
            return intArrayOf(hashMap[complement]!!+1, i+1)
        }
        hashMap[nums[i]] = i
    }
    return intArrayOf()
}